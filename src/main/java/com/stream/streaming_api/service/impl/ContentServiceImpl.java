package com.stream.streaming_api.service.impl;

import com.stream.streaming_api.constants.StreamingErrorCode;
import com.stream.streaming_api.error.exception.StreamingError;
import com.stream.streaming_api.error.exception.StreamingException;
import com.stream.streaming_api.model.Content;
import com.stream.streaming_api.model.ContentRate;
import com.stream.streaming_api.model.User;
import com.stream.streaming_api.model.UserContentView;
import com.stream.streaming_api.repository.ContentRateRepository;
import com.stream.streaming_api.repository.ContentRepository;
import com.stream.streaming_api.repository.UserContentViewRepository;
import com.stream.streaming_api.service.ContentService;
import com.stream.streaming_api.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ContentServiceImpl implements ContentService {

    private final ContentRepository contentRepository;
    private final ContentRateRepository contentRateRepository;
    private final UserContentViewRepository contentViewRepository;
    private final UserService userService;

    @Override
    public Content getRandomStreamingContent() {
        return contentRepository.getRandomContent();
    }

    @Override
    public Content getStreamingContent(UUID contentId) {
        return getContentById(contentId);
    }

    @Override
    public List<Content> getContents() {
        return null;
    }

    @Override
    public Content markContentAsViewed(UUID contentId, UUID userId) {
        Content content = getContentById(contentId);
        User user = userService.getUser(userId);
        List<UserContentView> contentViews = contentViewRepository.findByContentId(contentId);
        List<User> userIdsSeenContent = contentViews.stream().map(UserContentView::getUser).toList();

        if (userIdsSeenContent.contains(user)) {
            throw new StreamingException(HttpStatus.BAD_REQUEST, new StreamingError(StreamingErrorCode.CODE_400_USERS_VIEW, StreamingErrorCode.CODE_400_USERS_VIEW.getMessage()));
        }

        UserContentView view = new UserContentView(UUID.randomUUID(), content, user);
        contentViewRepository.save(view);

        content.setViews(content.getViews() + 1);
        contentRepository.save(content);

        return content;
    }

    @Override
    public Content rateContent(UUID contentId, ContentRate contentRate, UUID userId) {
        Content content = getContentById(contentId);
        User user = userService.getUser(userId);
        validateIsFirstUserRateToContent(contentId, userId);
        contentRate.setContent(content);
        contentRate.setUser(user);
        contentRateRepository.save(contentRate);
        updateContentRate(content);
        return content;
    }

    private void validateIsFirstUserRateToContent(UUID contentId, UUID userId) {
        Optional<ContentRate> rate = contentRateRepository.findByContentIdAndUserId(contentId, userId);
        if (rate.isPresent()) {
            throw new StreamingException(HttpStatus.BAD_REQUEST, new StreamingError(StreamingErrorCode.CODE_400_USERS_RATE, StreamingErrorCode.CODE_400_USERS_RATE.getMessage()));
        }
    }

    public Content getContentById(UUID contentId) {
        System.out.println(contentId);
        Optional<Content> content =contentRepository.findById(contentId);
        if (content.isEmpty()) {
            throw new StreamingException(HttpStatus.NOT_FOUND, new StreamingError(StreamingErrorCode.CODE_404, StreamingErrorCode.CODE_404.getMessage()));
        }
        return content.get();
    }

    private void updateContentRate(Content content) {
        List<ContentRate> rates = contentRateRepository.findByContentId(content.getId());
        double rateSum = rates.stream().mapToDouble(ContentRate::getRate).sum();
        double contentRate = rateSum / (double) rates.size();
        content.setRate(contentRate);
        contentRepository.save(content);
    }

}

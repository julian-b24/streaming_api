package com.stream.streaming_api.service.impl;

import com.stream.streaming_api.constants.StreamingErrorCode;
import com.stream.streaming_api.error.exception.StreamingError;
import com.stream.streaming_api.error.exception.StreamingException;
import com.stream.streaming_api.model.Content;
import com.stream.streaming_api.model.ContentRate;
import com.stream.streaming_api.repository.ContentRateRepository;
import com.stream.streaming_api.repository.ContentRepository;
import com.stream.streaming_api.service.ContentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ContentServiceImpl implements ContentService {

    private final ContentRepository contentRepository;
    private final ContentRateRepository contentRateRepository;

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
    public Content markContentAsViewed(String contentId) {
        return null;
    }

    @Override
    public Content rateContent(UUID contentId, ContentRate contentRate) {
        Content content = getContentById(contentId);
        contentRate.setContent(content);
        contentRateRepository.save(contentRate);
        updateContentRate(content);
        return content;
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

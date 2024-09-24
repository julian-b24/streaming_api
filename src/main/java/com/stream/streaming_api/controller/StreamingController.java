package com.stream.streaming_api.controller;

import com.stream.streaming_api.api.StreamingAPI;
import com.stream.streaming_api.constants.StreamingErrorCode;
import com.stream.streaming_api.dto.ContentDTO;
import com.stream.streaming_api.dto.ContentRateDTO;
import com.stream.streaming_api.error.exception.StreamingError;
import com.stream.streaming_api.error.exception.StreamingException;
import com.stream.streaming_api.mapper.ContentMapper;
import com.stream.streaming_api.mapper.ContentRateMapper;
import com.stream.streaming_api.service.ContentService;
import com.stream.streaming_api.utils.JWTParser;
import io.jsonwebtoken.Claims;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@AllArgsConstructor
public class StreamingController implements StreamingAPI {

    public final ContentService contentService;
    public final ContentMapper contentMapper;
    public final ContentRateMapper contentRateMapper;

    @Override
    public ContentDTO getRandomStreamingContent(String bearerToken) {
        validateToken(bearerToken);
        return contentMapper.fromContentToDTO(contentService.getRandomStreamingContent());
    }

    @Override
    public List<ContentDTO> getContents(String bearerToken, Boolean sortName, Boolean sortGender, Boolean sortRate) {
        validateToken(bearerToken);
        return contentService.getContents(sortName, sortGender, sortRate).stream().map(contentMapper::fromContentToDTO).collect(Collectors.toList());
    }


    @Override
    public ContentDTO getContent(String bearerToken, String contentId) {
        validateToken(bearerToken);
        return contentMapper.fromContentToDTO(contentService.getStreamingContent(UUID.fromString(contentId)));
    }

    @Override
    public List<ContentDTO> getContentsFilter(String bearerToken, String name, String gender, String type) {
        validateToken(bearerToken);
        return contentService.getContentsFilter(name, gender, type).stream().map(contentMapper::fromContentToDTO).collect(Collectors.toList());
    }

    @Override
    public ContentDTO markContentAsViewed(String bearerToken, String contentId, String userId) {
        validateToken(bearerToken);
        return contentMapper.fromContentToDTO(contentService.markContentAsViewed(UUID.fromString(contentId), UUID.fromString(userId)));
    }

    @Override
    public ContentDTO rateContent(String bearerToken, String contentId, @Valid ContentRateDTO contentRate, String userId) {
        validateToken(bearerToken);
        return contentMapper.fromContentToDTO(contentService.rateContent(UUID.fromString(contentId), contentRateMapper.fromDTOtoContentRate(contentRate), UUID.fromString(userId)));
    }

    private void validateToken(String bearerToken) {
        String token = bearerToken.replace("Bearer ", "");
        try {
            Claims jwtContent = JWTParser.decodeJWT(token);
        } catch (Exception e) {
            throw new StreamingException(HttpStatus.UNAUTHORIZED, new StreamingError(StreamingErrorCode.CODE_401_LOGIN,StreamingErrorCode.CODE_401_LOGIN.getMessage()));
        }

    }

}

package com.stream.streaming_api.controller;

import com.stream.streaming_api.api.StreamingAPI;
import com.stream.streaming_api.dto.ContentDTO;
import com.stream.streaming_api.dto.ContentRateDTO;
import com.stream.streaming_api.mapper.ContentMapper;
import com.stream.streaming_api.mapper.ContentRateMapper;
import com.stream.streaming_api.service.ContentService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
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
    public ContentDTO getRandomStreamingContent() {
        return contentMapper.fromContentToDTO(contentService.getRandomStreamingContent());
    }

    @Override
    public List<ContentDTO> getContents(Boolean sortName, Boolean sortGender, Boolean sortRate) {
        return contentService.getContents(sortName, sortGender, sortRate).stream().map(contentMapper::fromContentToDTO).collect(Collectors.toList());
    }


    @Override
    public ContentDTO getContent(String contentId) {
        return contentMapper.fromContentToDTO(contentService.getStreamingContent(UUID.fromString(contentId)));
    }

    @Override
    public ContentDTO markContentAsViewed(String contentId, String userId) {
        return contentMapper.fromContentToDTO(contentService.markContentAsViewed(UUID.fromString(contentId), UUID.fromString(userId)));
    }

    @Override
    public ContentDTO rateContent(String contentId, @Valid ContentRateDTO contentRate, String userId) {
        return contentMapper.fromContentToDTO(contentService.rateContent(UUID.fromString(contentId), contentRateMapper.fromDTOtoContentRate(contentRate), UUID.fromString(userId)));
    }
}

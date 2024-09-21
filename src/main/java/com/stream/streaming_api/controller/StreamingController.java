package com.stream.streaming_api.controller;

import com.stream.streaming_api.api.StreamingAPI;
import com.stream.streaming_api.dto.ContentDTO;
import com.stream.streaming_api.mapper.ContentMapper;
import com.stream.streaming_api.service.ContentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class StreamingController implements StreamingAPI {

    public final ContentService contentService;
    public final ContentMapper contentMapper;

    @Override
    public ContentDTO getRandomStreamingContent() {
        return contentMapper.fromContentToDTO(contentService.getRandomStreamingContent());
    }

    @Override
    public List<ContentDTO> getContents() {
        return null;
    }

    @Override
    public ContentDTO markContentAsViewed(String contentId) {
        return null;
    }

    @Override
    public ContentDTO rateContent(String contentId, Integer contentRate) {
        return null;
    }
}

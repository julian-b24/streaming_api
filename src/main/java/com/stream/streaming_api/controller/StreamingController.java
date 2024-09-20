package com.stream.streaming_api.controller;

import com.stream.streaming_api.api.StreamingAPI;
import com.stream.streaming_api.dto.ContentDTO;
import com.stream.streaming_api.service.ContentService;

import java.util.List;

public class StreamingController implements StreamingAPI {

    private ContentService contentService;

    @Override
    public ContentDTO getRandomStreamingContent() {
        return null;
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

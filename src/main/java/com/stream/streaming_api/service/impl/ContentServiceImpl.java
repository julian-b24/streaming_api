package com.stream.streaming_api.service.impl;

import com.stream.streaming_api.model.Content;
import com.stream.streaming_api.service.ContentService;

import java.util.List;

public class ContentServiceImpl implements ContentService {

    @Override
    public Content getRandomStreamingContent() {
        return null;
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
    public Content rateContent(String contentId, Integer contentRate) {
        return null;
    }
}

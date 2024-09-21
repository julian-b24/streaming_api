package com.stream.streaming_api.service.impl;

import com.stream.streaming_api.model.Content;
import com.stream.streaming_api.repository.ContentRepository;
import com.stream.streaming_api.service.ContentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ContentServiceImpl implements ContentService {

    private final ContentRepository contentRepository;

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

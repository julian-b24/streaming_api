package com.stream.streaming_api.service;

import com.stream.streaming_api.model.Content;
import com.stream.streaming_api.model.ContentRate;

import java.util.List;
import java.util.UUID;

public interface ContentService {

    Content getRandomStreamingContent();

    Content getStreamingContent(UUID contentId);

    List<Content> getContents();

    Content markContentAsViewed(UUID contentId, UUID userId);

    Content rateContent(UUID contentId, ContentRate contentRate);

}

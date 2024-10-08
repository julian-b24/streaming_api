package com.stream.streaming_api.service;

import com.stream.streaming_api.model.Content;
import com.stream.streaming_api.model.ContentRate;

import java.util.List;
import java.util.UUID;

public interface ContentService {

    Content getRandomStreamingContent();

    Content getStreamingContent(UUID contentId);

    List<Content> getContents(Boolean sortName, Boolean sortGender, Boolean sortRate);

    Content markContentAsViewed(UUID contentId, UUID userId);

    Content rateContent(UUID contentId, ContentRate contentRate, UUID userId);

    List<Content> getContentsFilter(String name, String gender, String type);

}

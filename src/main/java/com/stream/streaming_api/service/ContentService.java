package com.stream.streaming_api.service;

import com.stream.streaming_api.model.Content;

import java.util.List;

public interface ContentService {

    Content getRandomStreamingContent();

    List<Content> getContents();

    Content markContentAsViewed(String contentId);

    Content rateContent(String contentId, Integer contentRate);

}

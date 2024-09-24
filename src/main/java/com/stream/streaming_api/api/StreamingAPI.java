package com.stream.streaming_api.api;

import com.stream.streaming_api.dto.ContentDTO;
import com.stream.streaming_api.dto.ContentRateDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/streaming")
public interface StreamingAPI {

    @GetMapping("/content-random")
    ContentDTO getRandomStreamingContent();

    @GetMapping("/content")
    List<ContentDTO> getContents();

    @GetMapping("/content/{contentId}")
    ContentDTO getContent(@PathVariable String contentId);

    @PostMapping("/content/{contentId}/marked/{userId}")
    ContentDTO markContentAsViewed(@PathVariable String contentId, @PathVariable String userId);

    @PostMapping("/content/{contentId}/rate")
    ContentDTO rateContent(@PathVariable UUID contentId, @RequestBody ContentRateDTO contentRate);

}

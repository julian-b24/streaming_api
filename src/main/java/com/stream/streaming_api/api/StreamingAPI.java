package com.stream.streaming_api.api;

import com.stream.streaming_api.dto.ContentDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/streaming")
public interface StreamingAPI {

    @GetMapping("/content-random")
    ContentDTO getRandomStreamingContent();

    @GetMapping("/content")
    List<ContentDTO> getContents();

    @PatchMapping("/content/{contentId}/marked")
    ContentDTO markContentAsViewed(@PathVariable String contentId);

    @PatchMapping("/content/{contentId}/rate")
    ContentDTO rateContent(@PathVariable String contentId, @RequestBody Integer contentRate);

}

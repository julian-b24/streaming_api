package com.stream.streaming_api.api;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/streaming")
public interface StreamingAPI {

    @GetMapping("/content-random")
    public Integer getRandomStreamingContent();

    @GetMapping("/content")
    public List<Integer> getContents();

    @PatchMapping("/content/{contentId}/marked")
    public Integer markedContentAsViewed(@PathVariable String contentId);

    @PatchMapping("/content/{contentId}/rate")
    public Integer rateContent(@RequestBody Integer contentRate);

}

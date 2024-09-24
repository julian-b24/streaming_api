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
    ContentDTO getRandomStreamingContent(@RequestHeader(name = "Authorization") String bearerToken);

    @GetMapping("/content/{contentId}")
    ContentDTO getContent(
            @RequestHeader(name = "Authorization") String bearerToken,
            @PathVariable String contentId);

    @GetMapping("/content/filter")
    List<ContentDTO> getContentsFilter(
            @RequestHeader(required = false, name = "Authorization") String bearerToken,
            @RequestParam(required = false, name = "name") String name,
            @RequestParam(required = false, name = "gender") String gender,
            @RequestParam(required = false, name = "type") String type);

    @GetMapping("/content")
    List<ContentDTO> getContents(
            @RequestHeader(name = "Authorization") String bearerToken,
            @RequestParam(required = false, name = "sort_name") Boolean sortName,
            @RequestParam(required = false, name = "sort_gender") Boolean sortGender,
            @RequestParam(required = false, name = "sort_rate") Boolean sortRate);

    @PostMapping("/content/{contentId}/marked/{userId}")
    ContentDTO markContentAsViewed(
            @RequestHeader(name = "Authorization") String bearerToken,
            @PathVariable String contentId,
            @PathVariable String userId);

    @PostMapping("/content/{contentId}/rate/{userId}")
    ContentDTO rateContent(
            @RequestHeader(name = "Authorization") String bearerToken,
            @PathVariable String contentId,
            @RequestBody ContentRateDTO contentRate,
            @PathVariable String userId);

}

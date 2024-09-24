package com.stream.streaming_api.api;

import com.stream.streaming_api.dto.ContentDTO;
import com.stream.streaming_api.dto.ContentRateDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/streaming")
@Tag(name = "Streaming", description = "API for streaming content management")
public interface StreamingAPI {

    @Operation(summary = "Get random streaming content")
    @GetMapping("/content-random")
    ContentDTO getRandomStreamingContent(
            @Parameter(description = "Bearer token for authentication") @RequestHeader(name = "Authorization") String bearerToken
    );

    @Operation(summary = "Get specific content by ID")
    @GetMapping("/content/{contentId}")
    ContentDTO getContent(
            @Parameter(description = "Bearer token for authentication") @RequestHeader(name = "Authorization") String bearerToken,
            @Parameter(description = "ID of the content to be retrieved") @PathVariable String contentId
    );

    @Operation(summary = "Get filtered contents", description = "Fetch a list of streaming contents based on filters")
    @GetMapping("/content/filter")
    List<ContentDTO> getContentsFilter(
            @Parameter(description = "Bearer token for authentication") @RequestHeader(required = false, name = "Authorization") String bearerToken,
            @Parameter(description = "Filter by content name") @RequestParam(required = false, name = "name") String name,
            @Parameter(description = "Filter by content gender") @RequestParam(required = false, name = "gender") String gender,
            @Parameter(description = "Filter by content type") @RequestParam(required = false, name = "type") String type
    );

    @Operation(summary = "Get sorted contents", description = "Fetch a list of streaming contents and sort based on specified criteria")
    @GetMapping("/content")
    List<ContentDTO> getContents(
            @Parameter(description = "Bearer token for authentication") @RequestHeader(name = "Authorization") String bearerToken,
            @Parameter(description = "Sort by content name") @RequestParam(required = false, name = "sort_name") Boolean sortName,
            @Parameter(description = "Sort by content gender") @RequestParam(required = false, name = "sort_gender") Boolean sortGender,
            @Parameter(description = "Sort by content rate") @RequestParam(required = false, name = "sort_rate") Boolean sortRate
    );

    @Operation(summary = "Mark content as viewed by a user")
    @PostMapping("/content/{contentId}/marked/{userId}")
    ContentDTO markContentAsViewed(
            @Parameter(description = "Bearer token for authentication") @RequestHeader(name = "Authorization") String bearerToken,
            @Parameter(description = "ID of the content") @PathVariable String contentId,
            @Parameter(description = "ID of the user") @PathVariable String userId
    );

    @Operation(summary = "Rate a content by a user")
    @PostMapping("/content/{contentId}/rate/{userId}")
    ContentDTO rateContent(
            @Parameter(description = "Bearer token for authentication") @RequestHeader(name = "Authorization") String bearerToken,
            @Parameter(description = "ID of the content") @PathVariable String contentId,
            @Parameter(description = "Rating details") @RequestBody ContentRateDTO contentRate,
            @Parameter(description = "ID of the user") @PathVariable String userId
    );

}

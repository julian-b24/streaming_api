package com.stream.streaming_api.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContentRateDTO {

    @JsonIgnoreProperties(ignoreUnknown = true)
    private UUID contentId;

    @NotNull
    @Min(value = 1, message = "The content rate is not between the expected range. Range 1 to 5 (int).")
    @Max(value = 5, message = "The content rate is not between the expected range. Range 1 to 5 (int).")
    private int rate;
}

package com.stream.streaming_api.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum StreamingErrorCode {
    CODE_404("Content not found in our database.");

    private String message;
}

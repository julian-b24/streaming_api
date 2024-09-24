package com.stream.streaming_api.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum StreamingErrorCode {
    CODE_404("Content not found in our database."),
    CODE_400_LOGIN("Invalid nickname or password."),
    CODE_401_LOGIN("Not token found or expired token.");

    private String message;
}

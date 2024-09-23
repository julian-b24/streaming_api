package com.stream.streaming_api.error.exception;

import com.stream.streaming_api.constants.StreamingErrorCode;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StreamingError {
    private StreamingErrorCode code;
    private String message;
}

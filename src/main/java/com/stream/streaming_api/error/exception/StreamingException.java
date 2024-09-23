package com.stream.streaming_api.error.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Setter
@Getter
@AllArgsConstructor
public class StreamingException extends RuntimeException {
    private HttpStatus httpStatus;
    private StreamingError error;
}

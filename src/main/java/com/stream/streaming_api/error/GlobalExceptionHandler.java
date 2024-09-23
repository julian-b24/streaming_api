package com.stream.streaming_api.error;

import com.stream.streaming_api.error.exception.StreamingError;
import com.stream.streaming_api.error.exception.StreamingException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<StreamingError> handleException(StreamingException streamingException){
        return new ResponseEntity<>(streamingException.getError(), streamingException.getHttpStatus());
    }

}

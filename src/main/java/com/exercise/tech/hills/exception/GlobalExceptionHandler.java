package com.exercise.tech.hills.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({IllegalStateException.class, InvalidApiRequestException.class})
    public ResponseEntity<Object> handleExceptionGlobally(Exception ex, WebRequest request) {

        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("error", ex.getMessage());
        body.put("source", "api");

        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;

        if (ex instanceof IllegalStateException || ex instanceof InvalidApiRequestException) {
            status = HttpStatus.BAD_REQUEST;
        }

        return new ResponseEntity<>(body, status);
    }
}

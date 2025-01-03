package com.example.demo.adapter.http.allErrors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorsHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(ErrorsHandler.class);

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ErrorsResponse> handleRuntimeException(RuntimeException e) {
        ErrorsResponse errorsResponse = new ErrorsResponse(
                e.getMessage(),
                HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<>(errorsResponse, HttpStatus.NOT_FOUND);
    }
}

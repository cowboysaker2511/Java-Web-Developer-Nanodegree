package com.example.restapi_demo.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerControllerAdvice {
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity handleError() {
        return new ResponseEntity("DOG NOT FOUND", HttpStatus.NOT_FOUND);
    }
}

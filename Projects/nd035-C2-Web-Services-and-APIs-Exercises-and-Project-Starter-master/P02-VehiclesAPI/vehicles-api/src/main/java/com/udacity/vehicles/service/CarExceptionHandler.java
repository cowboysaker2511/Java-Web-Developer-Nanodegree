package com.udacity.vehicles.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.udacity.vehicles.api.ApiError;

import java.util.ArrayList;


@ControllerAdvice
public class CarExceptionHandler {
    @ExceptionHandler(CarNotFoundException.class)
    public ResponseEntity<ApiError> handleCarNotFoundException() {
        return new ResponseEntity<>(new ApiError("Car ID is not found", new ArrayList<>()), HttpStatus.NOT_FOUND);
    }
}

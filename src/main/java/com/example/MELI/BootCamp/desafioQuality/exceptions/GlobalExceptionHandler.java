package com.example.MELI.BootCamp.desafioQuality.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(DistrictNotFound.class)
    public ResponseEntity<String> solveConflict(DistrictNotFound error) {
        return new ResponseEntity<>(error.getMessage(), HttpStatus.NOT_FOUND);
    }
}

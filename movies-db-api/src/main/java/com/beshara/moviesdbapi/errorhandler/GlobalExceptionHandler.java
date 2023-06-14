package com.beshara.moviesdbapi.errorhandler;

import com.beshara.moviesdbapi.exceptions.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleNotFoundExceptions(NotFoundException ex) {
        var errorResponse = new ErrorResponse(HttpStatus.NOT_FOUND, ex);
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleAllExceptions(Exception ex) {
        var errorResponse = new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, ex);
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

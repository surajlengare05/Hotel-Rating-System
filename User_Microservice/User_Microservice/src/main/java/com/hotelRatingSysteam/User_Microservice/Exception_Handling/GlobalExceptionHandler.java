package com.hotelRatingSysteam.User_Microservice.Exception_Handling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler
{
    @ExceptionHandler(value = ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse> handlerForResourceNotFoundException(ResourceNotFoundException ex)
    {
        ApiResponse apiResponse = ApiResponse.builder()
                .message(ex.getMessage())
                .suggestion("Please enter valid credentials")
                .httpStatus(HttpStatus.NOT_FOUND)
                .build();
        return new ResponseEntity<>(apiResponse, HttpStatus.NOT_FOUND);
    }
}

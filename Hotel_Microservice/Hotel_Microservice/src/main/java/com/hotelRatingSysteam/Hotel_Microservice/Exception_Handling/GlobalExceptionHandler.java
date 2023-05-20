package com.hotelRatingSysteam.Hotel_Microservice.Exception_Handling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler
{
    @ExceptionHandler(value = ResourceNotFoundException.class)
    public ResponseEntity<Map<String, Object>> handlerForResourceNotFoundException(ResourceNotFoundException ex)
    {
        Map map = new LinkedHashMap();
        map.put("message", ex.getMessage());
        map.put("suggestion", "Please enter valid credentials");
        map.put("httpStatus", HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(map, HttpStatus.NOT_FOUND);
    }
}

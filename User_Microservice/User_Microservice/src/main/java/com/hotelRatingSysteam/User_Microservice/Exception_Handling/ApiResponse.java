package com.hotelRatingSysteam.User_Microservice.Exception_Handling;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class ApiResponse
{
    private String message;
    private String suggestion;
    private HttpStatus httpStatus;
}

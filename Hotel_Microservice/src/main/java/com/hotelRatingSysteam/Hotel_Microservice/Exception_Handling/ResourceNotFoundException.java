package com.hotelRatingSysteam.Hotel_Microservice.Exception_Handling;

public class ResourceNotFoundException extends RuntimeException
{
    public ResourceNotFoundException() {
        super("Resource not found on server !!");
    }

    public ResourceNotFoundException(String message) {
        super(message);
    }
}

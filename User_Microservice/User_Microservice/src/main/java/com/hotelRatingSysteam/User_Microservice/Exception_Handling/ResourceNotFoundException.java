package com.hotelRatingSysteam.User_Microservice.Exception_Handling;

public class ResourceNotFoundException extends RuntimeException
{                                                               // Write Constructors here
   public ResourceNotFoundException() {
        super("Resource not found on server !!");              // constructor-1    Non-parameterized
    }

   public ResourceNotFoundException(String message) {
        super(message);                                         // constructor-2   Parameterized
    }
}

package com.hotelRatingSysteam.User_Microservice.Models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Rating
{
    private int ratingId;
    private int userId;
    private int hotelId;
    private double rating;
    private String feedback;

    private Hotel hotel;

}

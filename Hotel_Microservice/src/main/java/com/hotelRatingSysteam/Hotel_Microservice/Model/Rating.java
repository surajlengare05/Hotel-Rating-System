package com.hotelRatingSysteam.Hotel_Microservice.Model;

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
    private double rating;
    private String feedback;
}

package com.hotelRatingSysteam.Hotel_Microservice.External_Servicess;

import com.hotelRatingSysteam.Hotel_Microservice.Model.Rating;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "RATING-MICROSERVICE")
public interface RatingService
{
   @GetMapping("/rating/getRatingsOfHotel")
   List<Rating> getRatings(@RequestParam("hotelId") int hotelId);
}

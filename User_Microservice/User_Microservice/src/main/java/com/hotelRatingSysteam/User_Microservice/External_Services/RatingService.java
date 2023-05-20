package com.hotelRatingSysteam.User_Microservice.External_Services;

import com.hotelRatingSysteam.User_Microservice.Models.Rating;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "RATING-MICROSERVICE")
public interface RatingService
{
    @GetMapping("/rating/getRatingsGivenByUser")
    List<Rating> getRatings(@RequestParam("userId") int userId);
}

package com.hotelRatingSysteam.Rating_Microservice.Controllers;

import com.hotelRatingSysteam.Rating_Microservice.Model.Rating;
import com.hotelRatingSysteam.Rating_Microservice.Services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/rating")
public class RatingController
{
    @Autowired
    RatingService ratingService;

    @PostMapping("/add")
    public ResponseEntity<String> addRating(@RequestBody Rating rating)
    {
        String result = ratingService.addRating(rating);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @GetMapping("/getAllRatings")
    public ResponseEntity<List<Rating>> getAllRatings()
    {
        List<Rating> ratingList = ratingService.getAllRatings();
        return new ResponseEntity<>(ratingList, HttpStatus.OK);
    }

    @GetMapping("/getRatingsGivenByUser")
    public ResponseEntity<List<Rating>> getRatingsGivenByUser(@RequestParam("userId") int userId)
    {
        List<Rating> ratingList = ratingService.getRatingsGivenByUser(userId);
        return new ResponseEntity<>(ratingList, HttpStatus.OK);
    }

    @GetMapping("/getRatingsOfHotel")
    public ResponseEntity<List<Rating>> getRatingsOfHotel(@RequestParam("hotelId") int hotelId)
    {
        List<Rating> ratingList = ratingService.getRatingsOfHotel(hotelId);
        return new ResponseEntity<>(ratingList, HttpStatus.OK);
    }

    @GetMapping("/getRatingById")
    public ResponseEntity<Rating> getRatingById(@RequestParam("id") int id)
    {
        Rating rating = ratingService.getRatingById(id);
        return new ResponseEntity<>(rating, HttpStatus.OK);
    }

    @GetMapping("/getAvgRatingOfHotel")
    public ResponseEntity<Double >getAvgRatingOfHotel(@RequestParam("hotelId") int hotelId)
    {
        double avg = ratingService.getAvgRatingOfHotel(hotelId);
        return new ResponseEntity<>(avg, HttpStatus.OK);
    }

    @GetMapping("/getAvgRatingsOfAllHotels")
    public ResponseEntity<Map<String, Double>> getAvgRatingsOfAllHotels()
    {
        Map<String, Double> arr = ratingService.getAvgRatingsOfAllHotels();
        return new ResponseEntity<>(arr, HttpStatus.OK);
    }
}

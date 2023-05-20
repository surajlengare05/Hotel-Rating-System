package com.hotelRatingSysteam.Rating_Microservice.Services;

import com.hotelRatingSysteam.Rating_Microservice.Exception_Handling.ResourceNotFoundException;
import com.hotelRatingSysteam.Rating_Microservice.Model.Rating;
import com.hotelRatingSysteam.Rating_Microservice.Repositories.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingService
{
    @Autowired
    RatingRepository ratingRepository;

    public String addRating(Rating rating)
    {
        ratingRepository.save(rating);
        return ("Rating added successfully");
    }

    public List<Rating> getAllRatings()
    {
        List<Rating> ratingList = ratingRepository.findAll();
        return ratingList;
    }

    public List<Rating> getRatingsGivenByUser(int userId)
    {
        List<Rating> ratingList = ratingRepository.findByUserId(userId);
        return ratingList;
    }

    public List<Rating> getRatingsOfHotel(int hotelId)
    {
        List<Rating> ratingList = ratingRepository.findByHotelId(hotelId);
        return ratingList;
    }

    public Rating getRatingById(int id)
    {
        Rating rating = ratingRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Rating with given Id does not exists !!"));
        return rating;
    }
}

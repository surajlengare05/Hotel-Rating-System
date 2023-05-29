package com.hotelRatingSysteam.Rating_Microservice.Services;

import com.hotelRatingSysteam.Rating_Microservice.Exception_Handling.ResourceNotFoundException;
import com.hotelRatingSysteam.Rating_Microservice.Model.Rating;
import com.hotelRatingSysteam.Rating_Microservice.Repositories.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RatingService
{
    @Autowired
    RatingRepository ratingRepository;

    @Autowired
    RestTemplate restTemplate;

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

    public double getAvgRatingOfHotel(int hotelId)
    {
        double avg = ratingRepository.findAvgRatingOfHotel(hotelId);
        return avg;
    }

    public Map<String, Double> getAvgRatingsOfAllHotels()
    {
        List<List<Double>> arr = ratingRepository.findAvgRatingsOfAllHotels();
        Map<String, Double> ratingMap = new HashMap<>();

        for (int i=0; i<arr.size(); i++)
        {
            int hotelId =  arr.get(i).get(0).intValue();      // converting double to int

            String name = restTemplate.getForObject("http://HOTEL-MICROSERVICE/hotel/getHotelNameById?hotelId=" + hotelId, String.class);
            ratingMap.put(name, arr.get(i).get(1));
        }

        return ratingMap;
    }
}

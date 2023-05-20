package com.hotelRatingSysteam.User_Microservice.Services;

import com.hotelRatingSysteam.User_Microservice.Exception_Handling.ResourceNotFoundException;
import com.hotelRatingSysteam.User_Microservice.External_Services.HotelService;
import com.hotelRatingSysteam.User_Microservice.External_Services.RatingService;
import com.hotelRatingSysteam.User_Microservice.Models.Hotel;
import com.hotelRatingSysteam.User_Microservice.Models.Rating;
import com.hotelRatingSysteam.User_Microservice.Models.User;
import com.hotelRatingSysteam.User_Microservice.Repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService
{
    @Autowired
    UserRepository userRepository;

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    HotelService hotelService;

    @Autowired
    RatingService ratingService;

    Logger logger = LoggerFactory.getLogger(UserService.class);


    public String addUser(User user)
    {
        userRepository.save(user);
        return ("User added successfully");
    }

    public User getUserById(int id)
    {
         User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User with given Id does not exists !!"));

         // Get ratings given by this user in Array format & then Convert it into ArrayList
                    // 1) Using RestTemplate
         Rating[] ratingArray = restTemplate.getForObject("http://RATING-MICROSERVICE/rating/getRatingsGivenByUser?userId=" + user.getId(), Rating[].class);
         List<Rating> ratingList =  Arrays.asList(ratingArray);

                   // 2) Using Feign client
         // List<Rating> ratingList = ratingService.getRatings(user.getId());

        // set Hotel attribute for each rating of above ratingList
        for (Rating rating : ratingList)
         {
                   // Using 1) RestTemplate
            Hotel hotel = restTemplate.getForObject("http://HOTEL-MICROSERVICE/hotel/getHotelById?hotelId=" + rating.getHotelId(), Hotel.class);
                   // 2) Using Feign client
            // Hotel hotel = hotelService.getHotel(rating.getHotelId());
             rating.setHotel(hotel);
         }

         user.setRatingsGiven(ratingList);
         return user;
    }

    public List<User> getAllUsers()
    {
        List<User> usersList = userRepository.findAll();
        return usersList;
    }
}

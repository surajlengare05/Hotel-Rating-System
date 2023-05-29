package com.hotelRatingSysteam.Hotel_Microservice.Services;

import com.hotelRatingSysteam.Hotel_Microservice.Exception_Handling.ResourceNotFoundException;
import com.hotelRatingSysteam.Hotel_Microservice.External_Servicess.RatingService;
import com.hotelRatingSysteam.Hotel_Microservice.Model.Hotel;
import com.hotelRatingSysteam.Hotel_Microservice.Model.Rating;
import com.hotelRatingSysteam.Hotel_Microservice.Repositories.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class HotelService
{
    @Autowired
    HotelRepository hotelRepository;

    @Autowired
    RatingService ratingService;

    public String addHotel(Hotel hotel)
    {
        hotelRepository.save(hotel);
        return ("Hotel added successfully");
    }

    public Hotel getHotelById(int id)
    {
        Hotel hotel = hotelRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Hotel with given Id does not exists !!"));
                             // Feign client
        List<Rating> ratingList = ratingService.getRatings(hotel.getId());
        hotel.setRatings(ratingList);
        return hotel;
    }

    public List<Hotel> getAllHotels()
    {
        List<Hotel> hotelList = hotelRepository.findAll();
        return hotelList;
    }

    public List<Hotel> getAllVegHotels()
    {
        List<Hotel> hotelList = hotelRepository.findAllVegHotels();
        return hotelList;
    }

    public List<Hotel> getAllNonVegHotels()
    {
        List<Hotel> hotelList = hotelRepository.findAllNonVegHotels();
        return hotelList;
    }

    public List<Hotel> getHotelsInArea(String area)
    {
        List<Hotel> hotelList = hotelRepository.findHotelsInArea(area);
        return hotelList;
    }

    public String getHotelNameById(int id)
    {
        Hotel hotel = hotelRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Hotel with given Id does not exists !!"));
        return hotel.getName();
    }
}


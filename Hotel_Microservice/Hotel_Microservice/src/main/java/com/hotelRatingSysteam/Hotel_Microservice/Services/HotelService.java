package com.hotelRatingSysteam.Hotel_Microservice.Services;

import com.hotelRatingSysteam.Hotel_Microservice.Exception_Handling.ResourceNotFoundException;
import com.hotelRatingSysteam.Hotel_Microservice.Model.Hotel;
import com.hotelRatingSysteam.Hotel_Microservice.Repositories.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelService
{
    @Autowired
    HotelRepository hotelRepository;

    public String addHotel(Hotel hotel)
    {
        hotelRepository.save(hotel);
        return ("Hotel added successfully");
    }

    public Hotel getHotelById(int id)
    {
        Hotel hotel = hotelRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Hotel with given Id does not exists !!"));
        return hotel;
    }

    public List<Hotel> getAllHotels()
    {
        List<Hotel> hotelList = hotelRepository.findAll();
        return hotelList;
    }
}

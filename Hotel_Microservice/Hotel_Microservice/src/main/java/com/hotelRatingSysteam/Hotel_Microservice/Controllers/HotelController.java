package com.hotelRatingSysteam.Hotel_Microservice.Controllers;

import com.hotelRatingSysteam.Hotel_Microservice.Model.Hotel;
import com.hotelRatingSysteam.Hotel_Microservice.Services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotel")
public class HotelController
{
    @Autowired
    HotelService hotelService;

    @PostMapping("/add")
    public ResponseEntity<String> addHotel(@RequestBody Hotel hotel)
    {
        String result = hotelService.addHotel(hotel);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @GetMapping("/getHotelById")
    public ResponseEntity<Hotel> getHotelById(@RequestParam("hotelId") int id)
    {
        Hotel hotel = hotelService.getHotelById(id);
        return new ResponseEntity<>(hotel, HttpStatus.OK);
    }

    @GetMapping("/getAllHotels")
    public ResponseEntity<List<Hotel>> getAllHotels()
    {
        List<Hotel> hotelList = hotelService.getAllHotels();
        return new ResponseEntity<>(hotelList, HttpStatus.OK);
    }
}

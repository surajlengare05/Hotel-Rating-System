package com.hotelRatingSysteam.User_Microservice.External_Services;

import com.hotelRatingSysteam.User_Microservice.Models.Hotel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "HOTEL-MICROSERVICE")
public interface HotelService
{
    @GetMapping("/hotel/getHotelById")
    Hotel getHotel(@RequestParam("hotelId") int hotelId);
}

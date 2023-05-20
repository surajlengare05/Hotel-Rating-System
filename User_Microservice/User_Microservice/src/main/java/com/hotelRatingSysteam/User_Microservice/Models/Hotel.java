package com.hotelRatingSysteam.User_Microservice.Models;

import com.hotelRatingSysteam.User_Microservice.Enum.HotelType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Hotel
{
    private int id;
    private String name;
    private String location;
    private HotelType hotelType;
}

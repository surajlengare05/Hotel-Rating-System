package com.hotelRatingSysteam.Hotel_Microservice.Model;

import com.hotelRatingSysteam.Hotel_Microservice.Enum.HotelType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Entity
@Table(name = "hotel")
public class Hotel
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private String name;
    private String location;

    @Enumerated(value = EnumType.STRING)
    private HotelType hotelType;

    @Transient
    private List<Rating> ratings;

}

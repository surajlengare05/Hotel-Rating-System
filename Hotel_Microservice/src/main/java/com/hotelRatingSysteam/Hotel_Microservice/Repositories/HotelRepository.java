package com.hotelRatingSysteam.Hotel_Microservice.Repositories;

import com.hotelRatingSysteam.Hotel_Microservice.Model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Integer>
{
    @Query(value = "select * from hotel where hotel_type='veg'", nativeQuery = true)
    List<Hotel> findAllVegHotels();

    @Query(value = "select * from hotel where hotel_type='non_veg'", nativeQuery = true)
    List<Hotel> findAllNonVegHotels();

    @Query(value = "select * from hotel where location=:area", nativeQuery = true)
    List<Hotel> findHotelsInArea(String area);



}

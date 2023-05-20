package com.hotelRatingSysteam.Hotel_Microservice.Repositories;

import com.hotelRatingSysteam.Hotel_Microservice.Model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Integer> {
}

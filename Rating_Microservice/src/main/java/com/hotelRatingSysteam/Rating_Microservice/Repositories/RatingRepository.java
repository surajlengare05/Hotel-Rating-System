package com.hotelRatingSysteam.Rating_Microservice.Repositories;

import com.hotelRatingSysteam.Rating_Microservice.Model.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RatingRepository extends JpaRepository<Rating, Integer>
{
    List<Rating> findByUserId(int userId);
    List<Rating> findByHotelId(int hotelId);
}

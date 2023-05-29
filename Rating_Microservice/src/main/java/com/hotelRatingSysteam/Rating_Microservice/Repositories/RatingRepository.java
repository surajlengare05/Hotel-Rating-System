package com.hotelRatingSysteam.Rating_Microservice.Repositories;

import com.hotelRatingSysteam.Rating_Microservice.Model.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface RatingRepository extends JpaRepository<Rating, Integer>
{
    List<Rating> findByUserId(int userId);
    List<Rating> findByHotelId(int hotelId);

    @Query(value = "select avg(rating) from rating where hotel_id=:hotelId", nativeQuery = true)
    double findAvgRatingOfHotel(int hotelId);

    @Query(value = "select hotel_id, avg(rating) from rating group by hotel_id", nativeQuery = true)
    List<List<Double>> findAvgRatingsOfAllHotels();
}

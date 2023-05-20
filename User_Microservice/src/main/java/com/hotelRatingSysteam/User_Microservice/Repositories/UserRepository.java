package com.hotelRatingSysteam.User_Microservice.Repositories;

import com.hotelRatingSysteam.User_Microservice.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}

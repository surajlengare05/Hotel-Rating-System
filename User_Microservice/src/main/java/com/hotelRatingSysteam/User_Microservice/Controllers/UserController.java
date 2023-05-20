package com.hotelRatingSysteam.User_Microservice.Controllers;

import com.hotelRatingSysteam.User_Microservice.Models.User;
import com.hotelRatingSysteam.User_Microservice.Services.UserService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController
{
    @Autowired
    UserService userService;

    Logger logger = LoggerFactory.getLogger(UserController.class);


    @PostMapping("/add")
    public ResponseEntity<String> addUser(@RequestBody User user)
    {
        String result = userService.addUser(user);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    //int retryCount = 1;

    @GetMapping("/getUserById")
   // @CircuitBreaker(name = "ratingHotelBreaker", fallbackMethod = "ratingHotelFallback")
   // @Retry(name = "ratingHotelRetry", fallbackMethod = "ratingHotelFallback")
    @RateLimiter(name = "userRateLimiter", fallbackMethod = "ratingHotelFallback")
    public ResponseEntity<User> getUserById(@RequestParam("userId") int id)
    {
        //logger.info("Retry count: {}", retryCount);
        //retryCount++;
       User user = userService.getUserById(id);
       return new ResponseEntity<>(user, HttpStatus.OK);
    }

    public ResponseEntity<User> ratingHotelFallback(int id, Exception ex)
    {
        logger.info("Fallback method (ratingHotelFallback) is called since some service is down :" + ex.getMessage());
        User user = User.builder()
                .id(0)
                .name("dummy")
                .age((0))
                .email("dummy@gmail.com")
                .mobNo("000000")
                .build();
        return new ResponseEntity<>(user, HttpStatus.OK);
    }


    @GetMapping("/getAllUsers")
    public ResponseEntity<List<User>> getAllUsers()
    {
        List<User> userList = userService.getAllUsers();
        return new ResponseEntity<>(userList, HttpStatus.OK);
    }
}

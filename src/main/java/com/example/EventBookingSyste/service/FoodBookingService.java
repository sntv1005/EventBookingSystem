package com.example.EventBookingSyste.service;

import com.example.EventBookingSyste.Request.FoodBooking;
import com.example.EventBookingSyste.model.Food;
import com.example.EventBookingSyste.repository.FoodBookingRepository;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@Slf4j
public class FoodBookingService {

    @Autowired
    private FoodBookingRepository foodBookingRepository;

    public Food saveFoodBooking(FoodBooking request) {
        log.info("Received food booking request: " + request);
        log.info("Booking details: " + request);
        Food booking = new Food();
        booking.setState(request.getState());
        booking.setDistrict(request.getDistrict());
        booking.setRestaurant(request.getRestaurant());
        booking.setFoodItem(request.getFoodItem());
        booking.setQuantity(request.getQuantity());
        booking.setPrice(request.getPrice());
        booking.setUserEmail(request.getUserEmail());
        booking.setBookingTime(LocalDateTime.now());
        
        booking.setBookingStatus("Confirmed"); // Set the booking status to "Confirmed"
        log.info("Booking details: " + booking);
        return foodBookingRepository.save(booking);
    }
}

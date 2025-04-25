package com.example.EventBookingSyste.controller;


import com.example.EventBookingSyste.Request.FoodBooking;
import com.example.EventBookingSyste.model.Food;
import com.example.EventBookingSyste.service.FoodBookingService;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/food-bookings")
@Slf4j
public class FoodBookingController {

    @Autowired
    private FoodBookingService foodBookingService;

    @PostMapping("/save")
    public ResponseEntity<Food> saveFoodBooking(@RequestBody FoodBooking booking) {
        log.info("Received food booking request: " + booking);
        log.info("Booking details: " + booking);
        Food saved = foodBookingService.saveFoodBooking(booking);
        log.info("Saved food booking: " + saved);
        // Return the saved booking details as a response
        // You can customize the response as needed
        // For example, you might want to return a status code or a message
        // along with the saved booking details.
        // Here, we're just returning the saved booking details with a 200 OK status.
        // You can also return a custom response object if needed.
        // For example:
        return ResponseEntity.ok().body(saved);
    }
}

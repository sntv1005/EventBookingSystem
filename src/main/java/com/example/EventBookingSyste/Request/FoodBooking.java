package com.example.EventBookingSyste.Request;

import java.time.LocalDateTime;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FoodBooking {
   
    private String state;
    private String district;
    private String restaurant;
    private String foodItem;
    private int quantity;
    private double price;
    private String userEmail;
    private LocalDateTime bookingTime;
}


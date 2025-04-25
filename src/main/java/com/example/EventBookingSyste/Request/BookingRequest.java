package com.example.EventBookingSyste.Request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookingRequest {

    private String mode;
    private String fromLocation;
    private String toLocation;
    private Integer seats;
    private Double totalAmount;
    private String paymentMethod;
    private String cardNumber;
    private String expiryDate;
    private String cvv;
    private String cardName;
    private String upiApp;
    private String upiNumber;

}


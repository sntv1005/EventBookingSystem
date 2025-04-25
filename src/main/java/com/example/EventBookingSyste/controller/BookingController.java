package com.example.EventBookingSyste.controller;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.EventBookingSyste.Request.BookingRequest;
import com.example.EventBookingSyste.model.Booking;
import com.example.EventBookingSyste.model.Payment;
import com.example.EventBookingSyste.service.BookingService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api")
@Slf4j
public class BookingController {

    @Autowired
    private BookingService bookingService;


    @PostMapping("/confirmBooking")
    public Booking confirmBooking(@RequestBody BookingRequest request) {
        log.info(null != request ? "Received booking request: " + request : "Received null booking request");

        Payment payment = new Payment();
        payment.setPaymentMethod(request.getPaymentMethod());
        if ("Debit/Credit Card".equals(request.getPaymentMethod())) {
            payment.setCardNumber(request.getCardNumber());
            payment.setExpiryDate(request.getExpiryDate());
            payment.setCvv(request.getCvv());
            payment.setCardName(request.getCardName());
        } else if (Objects.equals(request.getPaymentMethod(), "UPI")) {
            payment.setUpiApp(request.getUpiApp());
            payment.setUpiNumber(request.getUpiNumber());
        }  else {
            // Handle unknown or null payment method
            System.out.println("Invalid or missing payment method");
        }

        // Create the booking object
        Booking booking = new Booking();
        booking.setMode(request.getMode());
        booking.setFromLocation(request.getFromLocation());
        booking.setToLocation(request.getToLocation());
        booking.setSeats(request.getSeats());
        booking.setTotalAmount(request.getTotalAmount());
        booking.setPayment(payment);

        log.info("Booking details: " + booking);
        log.info("Payment details: " + payment);
        // Save booking and payment details
        return bookingService.saveBooking(booking, payment);
    }



}

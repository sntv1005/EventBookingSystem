package com.example.EventBookingSyste.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.EventBookingSyste.model.Booking;
import com.example.EventBookingSyste.model.Payment;
import com.example.EventBookingSyste.repository.BookingRepository;
import com.example.EventBookingSyste.repository.PaymentRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class BookingService {

   
    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private PaymentRepository paymentRepository;

    public Booking saveBooking(Booking booking, Payment payment) {
        // Save payment details first
        Payment savedPayment = paymentRepository.save(payment);

        // Assign saved payment to the booking
        booking.setPayment(savedPayment);
        log.info(null != booking ? "Received booking request: " + booking : "Received null booking request");
        log.info("Payment details: " + payment);
        // Set the booking time to the current time
        booking.setBookingTime(LocalDateTime.now());
        booking.setBookingstatus("Confirmed"); // Set the booking status to "Confirmed"
        log.info("Booking details: " + booking);
        

        // Save booking details
        return bookingRepository.save(booking);
    }

}

package com.example.EventBookingSyste.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.EventBookingSyste.model.Booking;

public interface BookingRepository extends JpaRepository<Booking, Long> {
    // Custom query methods can be defined here if needed
    // For example, find bookings by user, event, etc.
    
}

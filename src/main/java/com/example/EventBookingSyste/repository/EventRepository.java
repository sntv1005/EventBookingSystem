package com.example.EventBookingSyste.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.EventBookingSyste.model.Event;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
    // Custom query methods can be defined here if needed
    // For example, find events by date, location, etc.
    
}

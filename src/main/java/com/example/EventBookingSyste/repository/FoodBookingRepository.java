package com.example.EventBookingSyste.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.EventBookingSyste.model.Food;

@Repository
// This annotation is optional as JpaRepository already has @Repository
public interface FoodBookingRepository extends JpaRepository<Food, Long> {
    
    List<Food> findByUserEmail(String email);


}


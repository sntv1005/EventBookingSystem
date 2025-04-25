package com.example.EventBookingSyste.repository;

import java.util.Optional;

import com.example.EventBookingSyste.model.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);

    // void save(User user);

    
    
}

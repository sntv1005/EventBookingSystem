package com.example.EventBookingSyste.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.EventBookingSyste.model.User;
import com.example.EventBookingSyste.repository.UserRepository;

import java.util.Optional;

@Service
public class LoginService {

    @Autowired
    private UserRepository userRepository;

    public Optional<User> loginUser(String username, String password) {
        Optional<User> existingUser = userRepository.findByUsername(username);
    
        // Log to check if the user was found in the database
        if (existingUser.isPresent()) {
            System.out.println("User found: " + existingUser.get().getUsername());
        } else {
            System.out.println("User not found: " + username);
        }
    
        if (existingUser.isPresent() && existingUser.get().getPassword().equals(password)) {
            return existingUser;
        }
    
        return Optional.empty();
    }
    


    /**
     * Registers a new user if the username is not already taken.
     *
     * @param user The user to register.
     * @return true if the user was registered successfully, false if the username already exists.
     */



    public boolean registerUser(User user) {
        if (userRepository.findByUsername(user.getUsername()).isPresent()) {
            return false; // Username already exists
        }
        userRepository.save(user);
        return true;
    }
}


package com.backendlld.bookmyshowapr24morning.service;

import com.backendlld.bookmyshowapr24morning.model.User;
import com.backendlld.bookmyshowapr24morning.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.Optional;

@Service
public class UserService {
    private UserRepository userRepository;

    @Autowired
    public UserService(
            UserRepository userRepository
    ){
        this.userRepository = userRepository;
    }

    public User signUp(
            String username,
            String email,
            String password
    ){
        // 1. Email already registered
        Optional<User> userOptional = userRepository.findByEmail(email);
        if(userOptional.isPresent()){
            throw new RuntimeException("User already exists");
        }
        User user = new User();
        user.setName(username);
        user.setEmail(email);
        user.setPassword(password);
        user.setBookings(new ArrayList<>());
        //      1.1 if Yes, throw exception
        //      1.2 if No, create the user, save and return
        return userRepository.save(user);
    }
}

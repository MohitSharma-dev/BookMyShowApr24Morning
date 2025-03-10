package com.backendlld.bookmyshowapr24morning;

import com.backendlld.bookmyshowapr24morning.controller.BookingController;
import com.backendlld.bookmyshowapr24morning.controller.UserController;
import com.backendlld.bookmyshowapr24morning.dto.*;
import com.backendlld.bookmyshowapr24morning.model.BaseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

@EnableJpaAuditing
@SpringBootApplication
public class BookMyShowApr24MorningApplication implements CommandLineRunner {
    @Autowired
    private UserController userController;

    @Autowired
    private BookingController bookingController;

    @Override
    public void run(String... args) throws Exception {
        SignUpRequestDTO signUpRequest = new SignUpRequestDTO();
        signUpRequest.setUsername("Rohit Sharma");
        signUpRequest.setPassword("Mohit Sharma");
        signUpRequest.setEmail("rohitsharma@gmail.com");
        SignUpResponseDTO signUpResponse = userController.signUp(signUpRequest);
        System.out.println(signUpResponse.getMessage());


        BookingRequestDTO bookingRequest = new BookingRequestDTO();
        bookingRequest.setUserEmail("rohitsharma@gmail.com");
        bookingRequest.setBookingDate(new Date());
        bookingRequest.setShowId(1L);
        bookingRequest.setSeatIds(new ArrayList<>(Arrays.asList(1L, 2L, 3L)));
        BookingResponseDTO bookingResponse = bookingController.bookTicket(bookingRequest);
        System.out.println(bookingResponse.getMessage());

    }

    public static void main(String[] args) {
//        BaseModel baseModel = new BaseModel();
//        baseModel.getId();
        SpringApplication.run(BookMyShowApr24MorningApplication.class, args);
    }

}


// 1. Project setup is done
// 2. Set up your directories

// Hibernate

// Class <-> Table
// Object Relation Mapping : Hibernate

// I want to convert certain classes into entities / tables



// Booking Show

// BookingController
    // bookShow
        // request : showId, List<Long> showSeatIds, userId
        // response : bookingId , amount, bookedSeats , showDetails,  status
// BookingService
    // bookShow : params
        // get the seats information : ShowSeatRepo , ShowRepo
        // if all are available
        // we will block the seats
        // if not available , throw an exception
        // create a booking object, save it and return it : BookingRepo

// Raise a PR


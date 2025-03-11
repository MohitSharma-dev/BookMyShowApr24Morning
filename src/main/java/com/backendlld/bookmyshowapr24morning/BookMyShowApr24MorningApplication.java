package com.backendlld.bookmyshowapr24morning;

import com.backendlld.bookmyshowapr24morning.controller.BookingController;
import com.backendlld.bookmyshowapr24morning.controller.UserController;
import com.backendlld.bookmyshowapr24morning.dto.*;
import com.backendlld.bookmyshowapr24morning.model.BaseModel;
import com.backendlld.bookmyshowapr24morning.model.Booking;
import com.backendlld.bookmyshowapr24morning.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.ArrayList;
import java.util.List;

@EnableJpaAuditing
@SpringBootApplication
public class BookMyShowApr24MorningApplication implements CommandLineRunner {
    @Autowired
    private UserController userController;
    @Autowired
    private BookingController bookingController;

    @Override
    public void run(String... args) throws Exception {
        SignUpRequestDTO request = new SignUpRequestDTO();

        /*request.setUsername("Rohit Sharma");
        request.setPassword("Mohit Sharma");
        request.setEmail("rohitsharma@gmail.com");*/

        //SignUp-flow
        /*request.setUsername("puneet2");
        request.setPassword("password2");
        request.setEmail("puneet2@hotmail.com");
        SignUpResponseDTO responseDTO = userController.signUp(request);
        System.out.println(responseDTO.getMessage());*/

        //Booking-flow
        /*BookingRequestDTO requestDTO = new BookingRequestDTO();
        long showId=1;
        List<Long> showSeatIds = new ArrayList<>();
        showSeatIds.add(1l);
        long userId=5;
        requestDTO.setShowId(showId);
        requestDTO.setUserId(userId);
        requestDTO.setShowSeatIds(showSeatIds);

        BookingResponseDTO bookingResponseDTO = bookingController.bookShow(requestDTO);
        System.out.println(bookingResponseDTO.getBookingId());*/
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


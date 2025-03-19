package com.backendlld.bookmyshowapr24morning;

import com.backendlld.bookmyshowapr24morning.command.Command;
import com.backendlld.bookmyshowapr24morning.command.CommandExecutor;
import com.backendlld.bookmyshowapr24morning.command.SignUpUserCommand;
import com.backendlld.bookmyshowapr24morning.controller.UserController;
import com.backendlld.bookmyshowapr24morning.dto.ResponseStatus;
import com.backendlld.bookmyshowapr24morning.dto.SignUpRequestDTO;
import com.backendlld.bookmyshowapr24morning.dto.SignUpResponseDTO;
import com.backendlld.bookmyshowapr24morning.model.BaseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@EnableJpaAuditing
@SpringBootApplication
public class BookMyShowApr24MorningApplication implements CommandLineRunner {
    @Autowired
    private UserController userController;
    @Autowired
    private CommandExecutor commandExecutor;
    private static Scanner scanner = new Scanner(System.in);
//    private List<Command> commands;
    @Override
    public void run(String... args) throws Exception {
//        commands = new ArrayList<>();
//        commands.add(new SignUpUserCommand());
        SignUpRequestDTO request = new SignUpRequestDTO();
        request.setUsername("Rohit Sharma");
        request.setPassword("Mohit Sharma");
        request.setEmail("rohitsharma@gmail.com");

        SignUpResponseDTO responseDTO = userController.signUp(request);
        System.out.println(responseDTO.getMessage());

        System.out.println("Please enter the command : ");
        String input = scanner.nextLine();
        String[] words = input.split(" ");
        commandExecutor.execute(input);
//
//        for(Command command : commands) {
//            if(command.matches(input)){
//                command.execute(input);
//            }
//        }
//        if(words[0].equals("SignUp")){
//            // parse the arguments
//            if(words.length != 4){
//                //
//            }
//            // call the required controller
//        } else if (words[0].equals("GetMovies")){
//
//        } else if (words[0].equals("BookTicket")){
//
//        }


        // Command : match , execute
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


// SignUpUser Mohit mohit.sharma@scaler.com password


// SettleUpGroup 1

// [Command Name] [arg1] [arg2] [arg3]

// User enters command
    // match it with some command
    // accordingly parse the arguments
    // corresponding controller

package com.backendlld.bookmyshowapr24morning.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.awt.print.Book;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
public class Booking extends BaseModel {
    private Date bookingDate;
    @ManyToOne
    private Show show;
    @ManyToMany
    private List<ShowSeat> seats;
    @ManyToOne
    private User user;
    @OneToMany
    private List<Payment> payments;
    @ManyToOne
    BookingStatus bookingStatus;//added booing status for maintaining status of booking.
}


// Booking M : 1 User
// Booking M:1 Show


// Booking ?? : M ShowSeats

// cancellation

// Show me my bookings

//Booking table
//        1 Mohit Show1 Cancelled
//
//ShowSeat table
//        Show1 Seat1 null Available


// HW :
// Complete all the cardinalities
// How do you represent the cardinalities of enums
// Try to run the application : You will face certain issues
// Try to debug the issues : chatgpt / google
// OneToMany , ManyToOne : Do we create a new table ? No : when app run successfully, separate tables will be created
// How to avoid this ?


// Sign Up
// email password

// Controller : UserController
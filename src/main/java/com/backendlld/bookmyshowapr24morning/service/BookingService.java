package com.backendlld.bookmyshowapr24morning.service;

import com.backendlld.bookmyshowapr24morning.model.*;
import com.backendlld.bookmyshowapr24morning.repository.BookingRepository;
import com.backendlld.bookmyshowapr24morning.repository.ShowRepository;
import com.backendlld.bookmyshowapr24morning.repository.ShowSeatRepository;
import com.backendlld.bookmyshowapr24morning.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BookingService {
    private BookingRepository bookingRepository;
    private UserRepository userRepository;
    private ShowRepository showRepository;
    private ShowSeatRepository showSeatRepository;

    @Autowired
    public BookingService(BookingRepository bookingRepository,
                          UserRepository userRepository,
                          ShowRepository showRepository,
                          ShowSeatRepository showSeatRepository) {
        this.bookingRepository = bookingRepository;
        this.userRepository = userRepository;
        this.showRepository = showRepository;
        this.showSeatRepository = showSeatRepository;

    }

    public Booking bookTicket(String userEmail, Long showId, Date bookingDate, List<Long> seatIds) {

        Optional<User> user = userRepository.findByEmail(userEmail);
        if(!user.isPresent()){
            throw new RuntimeException("User does not exists");
        }

        Optional<Show> show = showRepository.findById(showId);
        if(!show.isPresent()){
            throw new RuntimeException("Show does not exist");
        }

        List<ShowSeat> bookedSeats = new ArrayList<>();
        for(Long seatId : seatIds){
            Optional<ShowSeat> showSeat = show.get().getShowSeats().stream()
                    .filter(s -> Objects.equals(s.getId(), seatId) && s.getStatus() == ShowSeatStatus.AVAILABLE)
                    .findAny();
            if(showSeat.isPresent()){
                bookedSeats.add(showSeat.get());
                showSeat.get().setStatus(ShowSeatStatus.BLOCKED);
                showSeatRepository.save(showSeat.get());
            } else {
                throw new RuntimeException("One or more seats are not available");
            }
        }

        Booking booking = new Booking();
        booking.setShow(show.get());
        booking.setSeats(bookedSeats);
        booking.setBookingDate(bookingDate);
        booking.setUser(user.get());
        booking.setPayments(new ArrayList<>());
        return bookingRepository.save(booking);
    }
}

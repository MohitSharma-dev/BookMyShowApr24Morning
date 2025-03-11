package com.backendlld.bookmyshowapr24morning.service;

import com.backendlld.bookmyshowapr24morning.model.*;
import com.backendlld.bookmyshowapr24morning.repository.BookingRepository;
import com.backendlld.bookmyshowapr24morning.repository.ShowRepository;
import com.backendlld.bookmyshowapr24morning.repository.ShowSeatRepository;
import com.backendlld.bookmyshowapr24morning.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BookingService {
    private final UserRepository userRepository;
    private BookingRepository bookingRepository;
    private ShowSeatRepository showSeatRepository;
    private ShowRepository showRepository;

    @Autowired

    public BookingService(BookingRepository bookingRepository, ShowSeatRepository showSeatRepository, ShowRepository showRepository, UserRepository userRepository) {
        this.bookingRepository = bookingRepository;
        this.showSeatRepository = showSeatRepository;
        this.showRepository = showRepository;
        this.userRepository = userRepository;
    }

    public Booking bookShow(List<Long> showSeatIds, Long showId, Long userId){
        Optional<Show> showOptional = showRepository.findById(showId);
        Show show;

        if(showOptional.isEmpty()){
            throw new RuntimeException("No such show present");
        }else{
            show = showOptional.get();
        }

        List<ShowSeat> showSeats = showSeatRepository.findAllById(showSeatIds);
        for(ShowSeat showSeat : showSeats){
            // TODO: Check if show seat is for same show we got in argument
            if(showSeat.getStatus() != ShowSeatStatus.AVAILABLE){
                throw new RuntimeException("Not all seats available");
            }
        }

        for(ShowSeat showSeat : showSeats){
            showSeat.setStatus(ShowSeatStatus.BLOCKED);
            showSeatRepository.save(showSeat);
        }

        Booking booking = new Booking();
        booking.setShow(show);
        Optional<User> user = userRepository.findById(userId);
        if(user.isEmpty()){
            throw new RuntimeException("No such user");
        }else{
            booking.setUser(user.get());
        }
        booking.setBookingDate(new Date());

        return bookingRepository.save(booking);
    }
}

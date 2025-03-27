package com.backendlld.bookmyshowapr24morning.service;


import com.backendlld.bookmyshowapr24morning.model.*;
import com.backendlld.bookmyshowapr24morning.repository.BookingRepository;
import com.backendlld.bookmyshowapr24morning.repository.ShowRepository;
import com.backendlld.bookmyshowapr24morning.repository.ShowSeatsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BookingService {
    private ShowSeatsRepository showSeatsRepository;
    private ShowRepository showRepository;
    private BookingRepository bookingRepository;

    @Autowired
    public BookingService(ShowSeatsRepository showSeatsRepository, ShowRepository showRepository, BookingRepository bookingRepository){
        this.showRepository = showRepository;
        this.showSeatsRepository = showSeatsRepository;
        this.bookingRepository = bookingRepository;
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public Booking bookShow(Long showId, List<Long> showSeatIds, Long userId) {
        //get the show info
        Optional<Show> showOptional = showRepository.findById(showId);
        if(showOptional.isEmpty()){
            throw new RuntimeException("Selected show not available");
        }
        Show show = showOptional.get();
        //find available selected seats for this show
        List<ShowSeat> showSeats = showSeatsRepository.findByShowIdAndSeatIdInAndStatus(show,showSeatIds, ShowSeatStatus.AVAILABLE.ordinal());
        //if all selected seats are not available
        if(showSeats.isEmpty() || showSeats.size() != showSeatIds.size()){
            throw new RuntimeException("All selected seats are not available");
        }
        showSeats.forEach(showSeat -> showSeat.setStatus(ShowSeatStatus.BOOKED));
        showSeatsRepository.saveAll(showSeats);
        //create booking object
        User user = new User();
        user.setId(userId);
        Booking booking = new Booking();
        booking.setBookingDate(new Date());
        booking.setShow(show);
        booking.setSeats(showSeats);
        booking.setUser(user);
        return bookingRepository.save(booking);
    }
}

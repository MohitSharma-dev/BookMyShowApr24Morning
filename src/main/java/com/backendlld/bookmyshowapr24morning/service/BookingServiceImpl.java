package com.backendlld.bookmyshowapr24morning.service;

import com.backendlld.bookmyshowapr24morning.excptions.ShowNotAvailableException;
import com.backendlld.bookmyshowapr24morning.excptions.SeatsNotAvailableExcpetion;
import com.backendlld.bookmyshowapr24morning.excptions.UserNotFoundException;
import com.backendlld.bookmyshowapr24morning.model.*;
import com.backendlld.bookmyshowapr24morning.repository.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookingServiceImpl implements BookingService {

    BookingRepository bookingRepository;
    ShowSeatRepository showSeatRepository;
    ShowRepository showRepository;
    UserRepository userRepository;
    PaymentRepository paymentRepository;

    public BookingServiceImpl(BookingRepository bookingRepository,
                       ShowSeatRepository showSeatRepository,
                       ShowRepository showRepository,
                       UserRepository userRepository,
                       PaymentRepository paymentRepository
                       ){
        this.bookingRepository = bookingRepository;
        this.showSeatRepository= showSeatRepository;
        this.showRepository= showRepository;
        this.userRepository = userRepository;
        this.paymentRepository = paymentRepository;
    }

    @Override
    public Booking bookShow(long showId, List<Long> showSeatIds, long userId) throws SeatsNotAvailableExcpetion, ShowNotAvailableException, UserNotFoundException {
        List<ShowSeat> showSeats = showSeatRepository.findAllById(showSeatIds);
        boolean seatsAvailble = checkSeatsAvailability(showSeats);
        Booking booking = new Booking();

        if(seatsAvailble){
            booking.setBookingDate(new java.util.Date(System.currentTimeMillis()));//I ams assuming user can book seats only for todays's show.

            Show show =  showRepository.findById(showId).orElseThrow( () ->  new ShowNotAvailableException(" Show id not found"));
            booking.setShow(show);
            User user = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException("User id"+ userId + "does not exist"));
            booking.setUser(user);
            booking.setSeats(showSeats);
            booking.setPayments(paymentRepository.findByBookingId(booking.getId()));
            booking.setBookingStatus(BookingStatus.SUCCESSFUL);

        }
        else {
            throw new SeatsNotAvailableExcpetion("Requested Seats are not available ! please try again");
        }

        return bookingRepository.save(booking);
    }


    //Helper function
    private boolean checkSeatsAvailability(List<ShowSeat> showSeats){
        for( ShowSeat showSeat: showSeats){
            if(showSeat.getStatus() != ShowSeatStatus.AVAILABLE)
                return false;
        }
        return true;
    }
}
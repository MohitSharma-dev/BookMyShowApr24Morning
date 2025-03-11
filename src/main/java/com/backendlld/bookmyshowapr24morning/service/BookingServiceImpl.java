package com.backendlld.bookmyshowapr24morning.service;

import com.backendlld.bookmyshowapr24morning.excptions.ShowNotAvailableException;
import com.backendlld.bookmyshowapr24morning.excptions.SeatsNotAvailableException;
import com.backendlld.bookmyshowapr24morning.excptions.ShowSeatNotFoundException;
import com.backendlld.bookmyshowapr24morning.excptions.UserNotFoundException;
import com.backendlld.bookmyshowapr24morning.model.*;
import com.backendlld.bookmyshowapr24morning.repository.*;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.locks.ReentrantLock;

@Service
public class BookingServiceImpl implements BookingService {

    BookingRepository bookingRepository;
    ShowSeatRepository showSeatRepository;
    ShowRepository showRepository;
    UserRepository userRepository;
    SeatRepository seatRepository;
    PaymentRepository paymentRepository;

    private ReentrantLock lock = new ReentrantLock();

    public BookingServiceImpl(BookingRepository bookingRepository,
                       ShowSeatRepository showSeatRepository,
                       ShowRepository showRepository,
                       UserRepository userRepository,
                       SeatRepository seatRepository,
                       PaymentRepository paymentRepository
                       ){
        this.bookingRepository = bookingRepository;
        this.showSeatRepository= showSeatRepository;
        this.showRepository= showRepository;
        this.userRepository = userRepository;
        this.seatRepository = seatRepository;
        this.paymentRepository = paymentRepository;
    }

    @Override
    public Booking bookShow(long showId, List<Long> showSeatIds, long userId) throws SeatsNotAvailableException, ShowNotAvailableException, UserNotFoundException, ShowSeatNotFoundException {
        User user = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException("user not found"));

        List<ShowSeat> showSeats = new ArrayList<>();

        Show show = null;

        for(Long showSeatId: showSeatIds) {
            lock.lock();
            ShowSeat showSeat = showSeatRepository.findById(showSeatId).orElseThrow(() -> new ShowSeatNotFoundException("showseat not found"));
            if(!showSeat.getStatus().equals(ShowSeatStatus.AVAILABLE))
                throw new SeatsNotAvailableException("seat is blocked currently");
            if( show == null) {
                show = showSeat.getShow();
            }
            showSeat.setStatus(ShowSeatStatus.BLOCKED);

            //add to the list of show Seats getting booked here.
            showSeats.add(showSeat);
            showSeatRepository.save(showSeat);
            lock.unlock();
        }
        //Assuming here payment system is called and  payment is made successfully.As we are not focussing on payment flow, so just takking it that paymnt is
        // done already here in this place after this for-loop, so we will just save the payment id into booking object.

        Booking booking = new Booking();

        booking.setUser(user);
        booking.setSeats(showSeats);
        booking.setPayments(paymentRepository.findByBookingId(booking.getId()));
        booking.setBookingStatus(BookingStatus.SUCCESSFUL);
        booking.setBookingDate(new Date());

        return bookingRepository.save(booking);
    }


    /// /////// /////// /////// /////// /////// /////// backup - commented for now as wrote new flow/////// /////// /////// /////// /////// /////// /////// ////
    /*public Booking bookShow_old_code(long showId, List<Long> showSeatIds, long userId) throws SeatsNotAvailableException, ShowNotAvailableException, UserNotFoundException {
        List<ShowSeat> showSeats = showSeatRepository.findAllById(showSeatIds);
        boolean seatsAvailable = checkSeatsAvailability(showSeats);
        Booking booking = new Booking();

        if(seatsAvailable){
            booking.setBookingDate(new java.util.Date(System.currentTimeMillis()));//I am assuming user can book seats only for todays's show.

            Show show =  showRepository.findById(showId).orElseThrow(() -> new ShowNotAvailableException(" Show id not found"));
            booking.setShow(show);
            User user = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException("User id"+ userId + "does not exist"));
            booking.setUser(user);
            booking.setSeats(showSeats);
            booking.setPayments(paymentRepository.findByBookingId(booking.getId()));
            booking.setBookingStatus(BookingStatus.SUCCESSFUL);

        }
        else {
            throw new SeatsNotAvailableException("Requested Seats are not available ! please try again");
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
    */

    /// /////// /////// /////// /////// /////// /////// /////// /////// /////// /////// /////// /////// /////// ////
}
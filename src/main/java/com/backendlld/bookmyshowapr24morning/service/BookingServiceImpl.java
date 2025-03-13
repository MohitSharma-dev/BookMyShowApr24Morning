package com.backendlld.bookmyshowapr24morning.service;

import com.backendlld.bookmyshowapr24morning.dto.BookingDetailsDto;
import com.backendlld.bookmyshowapr24morning.exceptions.SeatsNotAvailableException;
import com.backendlld.bookmyshowapr24morning.exceptions.ShowNotFoundException;
import com.backendlld.bookmyshowapr24morning.exceptions.ShowSeatNotFoundException;
import com.backendlld.bookmyshowapr24morning.exceptions.UserNotFoundException;
import com.backendlld.bookmyshowapr24morning.model.*;
import com.backendlld.bookmyshowapr24morning.repository.BookingRepository;
import com.backendlld.bookmyshowapr24morning.repository.ShowRepository;
import com.backendlld.bookmyshowapr24morning.repository.ShowSeatRepository;
import com.backendlld.bookmyshowapr24morning.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BookingServiceImpl implements BookingService{
    private UserRepository userRepository;
    private ShowRepository showRepository;
    private ShowSeatRepository showSeatRepository;
    private BookingRepository bookingRepository;

    @Autowired
    public BookingServiceImpl(UserRepository userRepository,
                              ShowRepository showRepository,
                              ShowSeatRepository showSeatRepository,
                              BookingRepository bookingRepository){
        this.userRepository=userRepository;
        this.showRepository=showRepository;
        this.showSeatRepository=showSeatRepository;
        this.bookingRepository=bookingRepository;
    }
    @Override
    public BookingDetailsDto bookMyShow(long userId, long showId, List<Long> showSeatIds) throws UserNotFoundException, ShowNotFoundException, ShowSeatNotFoundException, SeatsNotAvailableException {
        Optional<User> userOptional=userRepository.findById(userId);
        if(userOptional.isEmpty())
            throw new UserNotFoundException("User is not found by Id:"+userId);
        User user=userOptional.get();
        Optional<Show> showOptional=showRepository.findById(showId);
        if(showOptional.isEmpty())
            throw new ShowNotFoundException("Show is not found by Id: "+showId);
        Show show=showOptional.get();
        List<ShowSeat> showSeats=showSeatRepository.findAllById(showSeatIds);
        if(showSeats.size()!=showSeatIds.size())
            throw new ShowSeatNotFoundException("Some Show Seat is not found by your provided Ids: "+showSeatIds);
        Booking booking=new Booking();
        blockShowSeats(showSeats);
        booking.setBookingDate(new Date());
        List<ShowSeatType> showSeatTypes=show.getShowSeatTypes();
        double payableAmt=0;
        for(ShowSeatType showSeatType:showSeatTypes){
            payableAmt+= showSeatType.getPrice();
        }
        booking.setShow(show);
        booking.setUser(user);
        booking.setSeats(showSeats);
        booking.setPayments(new ArrayList<>());
        booking.setBookingStatus(BookingStatus.PENDING);
        booking=bookingRepository.save(booking);
        BookingDetailsDto bookingDetails=new BookingDetailsDto();
        bookingDetails.setBooking(booking);
        bookingDetails.setShowSeatsIds(showSeatIds);
        bookingDetails.setAmount(payableAmt);
        return bookingDetails;
    }
    @Transactional(isolation = Isolation.SERIALIZABLE)
    private void blockShowSeats(List<ShowSeat> showSeats) throws SeatsNotAvailableException {
        for(ShowSeat showSeat:showSeats){
            Date bookedDate;
            if(showSeat.getStatus()== ShowSeatStatus.BOOKED)
                throw new SeatsNotAvailableException("Show seat: "+showSeat.getId()+" is already booked..!");
            else if(showSeat.getStatus()==ShowSeatStatus.BLOCKED){
                if(showSeat.getUpdatedAt()==null)
                    bookedDate=showSeat.getCreatedAt();
                else
                    bookedDate=showSeat.getUpdatedAt();
                if(bookedDate!=null &&
                        (((System.currentTimeMillis()-bookedDate.getTime())/(1000*60*60))<15))
                    throw new SeatsNotAvailableException("Show Seat: "+showSeat.getId()+" is blocked for 15 Minutes");
            }
            showSeat.setStatus(ShowSeatStatus.BLOCKED);
            bookedDate=new Date();
            showSeat.setCreatedAt(bookedDate);
            showSeat.setUpdatedAt(bookedDate);
        }
        showSeatRepository.saveAll(showSeats);
    }
}


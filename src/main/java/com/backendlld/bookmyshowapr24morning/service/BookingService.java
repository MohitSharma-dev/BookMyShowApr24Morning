package com.backendlld.bookmyshowapr24morning.service;

import com.backendlld.bookmyshowapr24morning.dto.BookingDetailsDto;
import com.backendlld.bookmyshowapr24morning.exceptions.SeatsNotAvailableException;
import com.backendlld.bookmyshowapr24morning.exceptions.ShowNotFoundException;
import com.backendlld.bookmyshowapr24morning.exceptions.ShowSeatNotFoundException;
import com.backendlld.bookmyshowapr24morning.exceptions.UserNotFoundException;
import com.backendlld.bookmyshowapr24morning.model.Booking;

import java.util.List;

public interface BookingService {
    BookingDetailsDto bookMyShow(long userId, long showId, List<Long> showSeatIds) throws UserNotFoundException, ShowNotFoundException, ShowSeatNotFoundException, SeatsNotAvailableException;
}

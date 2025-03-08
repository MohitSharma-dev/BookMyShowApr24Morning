package com.backendlld.bookmyshowapr24morning.service;


import com.backendlld.bookmyshowapr24morning.excptions.SeatsNotAvailableExcpetion;
import com.backendlld.bookmyshowapr24morning.excptions.ShowNotAvailableException;
import com.backendlld.bookmyshowapr24morning.excptions.UserNotFoundException;
import com.backendlld.bookmyshowapr24morning.model.Booking;

import java.util.List;

public interface BookingService {
    Booking bookShow( long showId, List<Long> showSeatIds, long userId) throws SeatsNotAvailableExcpetion, ShowNotAvailableException, UserNotFoundException;
}

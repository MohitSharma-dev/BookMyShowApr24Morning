package com.backendlld.bookmyshowapr24morning.repository;

import com.backendlld.bookmyshowapr24morning.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
    Optional<Booking> findBookingById(long bookingId);
}

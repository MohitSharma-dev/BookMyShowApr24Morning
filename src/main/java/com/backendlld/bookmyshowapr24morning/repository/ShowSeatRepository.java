package com.backendlld.bookmyshowapr24morning.repository;

import com.backendlld.bookmyshowapr24morning.model.ShowSeat;
import com.backendlld.bookmyshowapr24morning.model.ShowSeatStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShowSeatRepository extends JpaRepository<ShowSeat, Long> {
    List<ShowSeat> getShowSeatsByStatus(ShowSeatStatus status);
}

package com.backendlld.bookmyshowapr24morning.repository;

import com.backendlld.bookmyshowapr24morning.model.Show;
import com.backendlld.bookmyshowapr24morning.model.ShowSeat;
import com.backendlld.bookmyshowapr24morning.model.ShowSeatStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ShowRepository extends JpaRepository<Show, Long> {
   Optional<Show> getShowById(Long id);
}

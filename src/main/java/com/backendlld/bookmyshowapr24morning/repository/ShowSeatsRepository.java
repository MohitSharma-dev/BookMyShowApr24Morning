package com.backendlld.bookmyshowapr24morning.repository;


import com.backendlld.bookmyshowapr24morning.model.Show;
import com.backendlld.bookmyshowapr24morning.model.ShowSeat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShowSeatsRepository extends JpaRepository<ShowSeat,Long> {
    List<ShowSeat> findByShowIdAndSeatIdInAndStatus(Show show, List<Long> showSeatIds, int ordinal);
}

package com.backendlld.bookmyshowapr24morning.repository;

import com.backendlld.bookmyshowapr24morning.model.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SeatRepository extends JpaRepository<Seat, Long> {

    @Override
    Optional<Seat> findById(Long aLong);

    @Override
    <S extends Seat> S save(S entity);
}

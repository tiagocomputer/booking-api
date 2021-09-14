package com.tiagocomputer.repository;

import com.tiagocomputer.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer> {

    Booking findByHotelId(Integer id);
}

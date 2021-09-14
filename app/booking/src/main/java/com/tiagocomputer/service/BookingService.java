package com.tiagocomputer.service;

import com.tiagocomputer.model.Booking;

import java.util.List;

public interface BookingService {

    List<Booking> getAllBooking();

    Booking createBooking(Booking booking);

    Booking updateBooking(Integer id, Booking booking);

    void deleteBooking(Integer id);

    Booking getBookingById(Integer id);

    void cancellationBooking(Integer id);
}

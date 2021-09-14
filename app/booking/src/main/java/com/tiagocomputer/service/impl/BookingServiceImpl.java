package com.tiagocomputer.service.impl;

import com.tiagocomputer.model.Booking;
import com.tiagocomputer.repository.BookingRepository;
import com.tiagocomputer.service.BookingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.List;

@Service
@Slf4j
public class BookingServiceImpl implements BookingService {
    private final BookingRepository bookingRepository;
    Boolean availableRoom = false;

    @Autowired
    public BookingServiceImpl(BookingRepository bookingRepository) {

        this.bookingRepository = bookingRepository;
    }

    @Override
    public List<Booking> getAllBooking() {
        return bookingRepository.findAll();
    }

    @Override
    public Booking createBooking(Booking booking) {
        Booking saveBooking = null;
        Booking byHotelId = bookingRepository.findByHotelId(booking.getId());
        boolean availeble = availebleToBooking(byHotelId);
        if (byHotelId.getHotel().getRoom().getFreeRoom() > 0 && availeble) {
            saveBooking = bookingRepository.save(booking);
        }
        return saveBooking;
    }

    boolean availebleToBooking(Booking booking) {
        log.info("Into Method Availeble To Booking");
        LocalDate bookingDay = booking.getBookingDay();
        LocalDate plusThrirtyDays = bookingDay.plusDays(30);
        LocalDate bookingStart = booking.getBookingStart();
        LocalDate startPlusThreeDays = bookingStart.plusDays(3);
        LocalDate endCantPlusThreeDay = booking.getBookingEnd();

        boolean startBefore = bookingStart.isBefore(plusThrirtyDays);
        boolean endBefore = endCantPlusThreeDay.isBefore(startPlusThreeDays);

        if (startBefore && endBefore) {
            availableRoom = true;
            return true;
        }
        return false;
    }

    @Override
    public Booking updateBooking(Integer id, Booking bookingUpdated) {
        return bookingRepository.findById(id)
                .map(booking -> {
                    bookingUpdated.setId(booking.getId());
                    return bookingRepository.save(bookingUpdated);
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Booking Not Found!"));
    }

    @Override
    public void deleteBooking(Integer id) {
        bookingRepository.findById(id)
                .map(hotel -> {
                    bookingRepository.delete(hotel);
                    return Void.TYPE;
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Not found booking to delete!"));
    }

    @Override
    public Booking getBookingById(Integer id) {
        return null;
    }

    @Override
    public void cancellationBooking(Integer id) {
        bookingRepository.findById(id)
                .map(hotel -> {
                    hotel.setCancellation(true);
                    return Void.TYPE;
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Not found booking to cancel!"));
    }
}

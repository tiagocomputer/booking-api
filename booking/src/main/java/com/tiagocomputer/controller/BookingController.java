package com.tiagocomputer.controller;

import com.tiagocomputer.model.Booking;
import com.tiagocomputer.service.BookingService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Tag(name = "Booking")
@RequestMapping("/api/v1/booking")
public class BookingController {
    private final BookingService bookingService;

    @Autowired
    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping
    @Operation(summary = "Create booking", responses = {
            @ApiResponse(description = "Create booking success", responseCode = "200",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = Booking.class))),
            @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content)
    })
    public ResponseEntity<Booking> createBooking(@RequestBody @Valid Booking request) {
        Booking response = bookingService.createBooking(request);
        if (response == null) {
            return ResponseEntity.badRequest().body(response);
        }
        return ResponseEntity.ok().body(response);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update booking", responses = {
            @ApiResponse(description = "Booking updated success", responseCode = "200",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = Booking.class))),
            @ApiResponse(description = "Not found booking to update", responseCode = "404", content = @Content)
    })
    public void updateBooking(@PathVariable Integer id, @RequestBody @Valid Booking booking) {
        bookingService.updateBooking(id, booking);
    }

    @GetMapping
    @Operation(summary = "Get all bookings", responses = {
            @ApiResponse(description = "Get booking success", responseCode = "200",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = Booking.class))),
            @ApiResponse(description = "Not content", responseCode = "204", content = @Content)
    })
    public List<Booking> getAllBookings() {
        return bookingService.getAllBooking();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get booking by id", responses = {
            @ApiResponse(description = "Get booking success", responseCode = "200",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = Booking.class))),
            @ApiResponse(description = "Not found booking", responseCode = "404", content = @Content)
    })
    public Booking getBooking(@PathVariable Integer id) {
        return bookingService.getBookingById(id);
    }

    @PutMapping("/cancel/{id}")
    @Operation(summary = "Cancelation booking", responses = {
            @ApiResponse(description = "Booking canceled success", responseCode = "200",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = Booking.class))),
            @ApiResponse(description = "Not found booking to cancel", responseCode = "404", content = @Content)
    })
    public void cancelBooking(@PathVariable Integer id) {
        bookingService.cancellationBooking(id);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deleting booking", responses = {
            @ApiResponse(description = "Booking deleted success", responseCode = "200",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = Booking.class))),
            @ApiResponse(description = "Not found booking to delete", responseCode = "404", content = @Content)
    })
    public void deleteBooking(@PathVariable Integer id) {
        bookingService.deleteBooking(id);
    }
}

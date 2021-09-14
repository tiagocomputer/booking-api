package com.tiagocomputer.controller;

import com.tiagocomputer.model.Hotel;
import com.tiagocomputer.service.HotelService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Tag(name = "Hotel")
@RequestMapping("/api/v1/hotel")
public class HotelController {
    private final HotelService hotelService;

    @Autowired
    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @PostMapping
    @Operation(summary = "Create hotel", responses = {
            @ApiResponse(description = "Create hotel success", responseCode = "200",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = Hotel.class))),
            @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content)
    })
    public ResponseEntity<Hotel> createHotel(@RequestBody @Valid Hotel request) {
        Hotel response = hotelService.createHotel(request);
        if (response == null) {
            return ResponseEntity.badRequest().body(response);
        }
        return ResponseEntity.ok().body(response);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update hotel", responses = {
            @ApiResponse(description = "Booking updated success", responseCode = "200",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = Hotel.class))),
            @ApiResponse(description = "Not found hotel to update", responseCode = "404", content = @Content)
    })
    public void updateHotel(@PathVariable Integer id, @RequestBody @Valid Hotel booking) {
        hotelService.updateHotel(id, booking);
    }

    @GetMapping
    @Operation(summary = "Get all hotels", responses = {
            @ApiResponse(description = "Get hotel success", responseCode = "200",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = Hotel.class))),
            @ApiResponse(description = "Not content", responseCode = "204", content = @Content)
    })
    public List<Hotel> getAllHotels() {
        return hotelService.getAllHotel();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get hotel by id", responses = {
            @ApiResponse(description = "Get hotel success", responseCode = "200",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = Hotel.class))),
            @ApiResponse(description = "Not found hotel", responseCode = "404", content = @Content)
    })
    public Hotel getHotel(@PathVariable Integer id) {
        return hotelService.getHotelById(id);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deleting hotel", responses = {
            @ApiResponse(description = "Hotel deleted success", responseCode = "200",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = Hotel.class))),
            @ApiResponse(description = "Not found hotel to delete", responseCode = "404", content = @Content)
    })
    public void deleteHotel(@PathVariable Integer id) {
        hotelService.deleteHotel(id);
    }
}

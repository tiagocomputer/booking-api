package com.tiagocomputer.service.impl;

import com.tiagocomputer.model.Hotel;
import com.tiagocomputer.repository.HotelRepository;
import com.tiagocomputer.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class HotelServiceImpl implements HotelService {
    private final HotelRepository hotelRepository;

    @Autowired
    public HotelServiceImpl(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    @Override
    public List<Hotel> getAllHotel() {
        return hotelRepository.findAll();
    }

    @Override
    public Hotel createHotel(Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    @Override
    public Hotel updateHotel(Integer id, Hotel hotelUpdated) {
        return hotelRepository.findById(id)
                .map(hotel -> {
                    hotelUpdated.setId(hotel.getId());
                    return hotelRepository.save(hotelUpdated);
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Hotel Not Found"));
    }

    @Override
    public void deleteHotel(Integer id) {
        hotelRepository.findById(id)
                .map(hotel -> {
                    hotelRepository.delete(hotel);
                    return Void.TYPE;
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Hotel Not Found!"));
    }

    @Override
    public Hotel getHotelById(Integer id) {
        return hotelRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Hotel Not Found!"));
    }


}

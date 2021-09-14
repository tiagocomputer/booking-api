package com.tiagocomputer.service;

import com.tiagocomputer.model.Hotel;

import java.util.List;

public interface HotelService {

    List<Hotel> getAllHotel();

    Hotel createHotel(Hotel post);

    Hotel updateHotel(Integer id, Hotel Hotel);

    void deleteHotel(Integer id);

    Hotel getHotelById(Integer id);

}

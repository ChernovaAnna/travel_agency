package com.epam.agency.service.impl;

import com.epam.agency.domain.Hotel;
import com.epam.agency.repository.impl.HotelRepository;
import com.epam.agency.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implements IService interface and
 * realizes it's methods
 *
 * @author Hanna_Charnova
 * @version 1.0
 * Description of methods:
 * @see IService
 */

@Service("hotelService")
public class HotelService implements IService<Hotel> {
    @Autowired
    private HotelRepository hotelRepository;

    @Override
    public void create(Hotel hotel) {
        hotelRepository.create(hotel);
    }

    @Override
    public void update(Hotel hotel) {
        hotelRepository.update(hotel);
    }

    @Override
    public void delete(Hotel hotel) {
        hotelRepository.delete(hotel);
    }

    @Override
    public List<Hotel> findAll() {
        return hotelRepository.findAll();
    }

    @Override
    public Hotel findById(int id) {
        return hotelRepository.findById(id);
    }
}

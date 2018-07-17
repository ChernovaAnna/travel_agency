package com.epam.agency.service.impl;

import com.epam.agency.domain.Hotel;
import com.epam.agency.repository.impl.HotelRepository;
import com.epam.agency.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("hotelService")
public class HotelService implements IService<Hotel> {
    @Autowired
    private HotelRepository hotelRepository;

    @Override
    public void create(Hotel entity) {
        hotelRepository.create(entity);
    }

    @Override
    public void update(Hotel entity) {
        hotelRepository.update(entity);
    }

    @Override
    public void delete(Hotel entity) {
        hotelRepository.delete(entity);
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

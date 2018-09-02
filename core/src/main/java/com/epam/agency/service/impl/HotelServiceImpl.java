package com.epam.agency.service.impl;

import com.epam.agency.domain.Hotel;
import com.epam.agency.exception.BusinessException;
import com.epam.agency.exception.type.BusinessExceptionCode;
import com.epam.agency.repository.HotelRepository;
import com.epam.agency.service.HotelService;
import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implements IService interface and
 * realizes it's methods
 *
 * @author Hanna_Charnova
 * @version 1.0
 * Description of methods:
 * @see HotelService
 */
@Service("hotelService")
@AllArgsConstructor
public class HotelServiceImpl implements HotelService {

    private HotelRepository hotelRepository;

    @Override
    public void create(Hotel hotel) {
        hotelRepository.save(hotel);
    }

    @Override
    public void update(Hotel hotel) {
        hotelRepository.save(hotel);
    }

    @Override
    public void delete(Hotel hotel) {
        hotelRepository.delete(hotel);
    }

    @Override
    public List<Hotel> findAll() {
        List<Hotel> hotels = Lists.newArrayList(hotelRepository.findAll());
        if (hotels.isEmpty()) {
            throw new BusinessException(BusinessExceptionCode.NO_HOTELS_FOUND);
        }
        return hotels;
    }

    @Override
    public Hotel findById(Long id) {
        return hotelRepository.findById(id).orElseThrow(() -> new BusinessException(BusinessExceptionCode.HOTEL_NOT_FOUND));
    }
}

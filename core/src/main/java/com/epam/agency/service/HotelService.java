package com.epam.agency.service;

import com.epam.agency.domain.Hotel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface HotelService {
    /**
     * Create Hotel in the repository.
     *
     * @param hotel
     */
    void create(Hotel hotel);

    /**
     * Update Hotel from the repository.
     *
     * @param hotel
     */
    void update(Hotel hotel);

    /**
     * Delete Hotel from the repository
     *
     * @param hotel
     */
    void delete(Hotel hotel);

    /**
     * @return all entities from concrete repository
     */
    List<Hotel> findAll();

    /**
     * Find Hotel by id in the repository
     *
     * @param id of Hotel
     * @return Hotel with corresponding id
     */
    Hotel findById(Long id);

}

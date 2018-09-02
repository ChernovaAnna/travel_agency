package com.epam.agency.service;

import com.epam.agency.domain.Tour;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TourService {
    /**
     * Create tour in the repository.
     *
     * @param tour
     */
    void create(Tour tour);

    /**
     * Update tour from the repository.
     *
     * @param tour
     */
    void update(Tour tour);

    /**
     * Delete tour from the repository
     *
     * @param tour
     */
    void delete(Tour tour);

    /**
     * @return all entities from concrete repository
     */
    List<Tour> findAll();

    /**
     * Find tour by id in the repository
     *
     * @param id of tour
     * @return tour with corresponding id
     */
    Tour findById(Long id);

}

package com.epam.agency.service.impl;

import com.epam.agency.domain.Tour;
import com.epam.agency.repository.jpa.TourRepository;
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

@Service("tourService")
public class TourService implements IService<Tour> {
    @Autowired
    private TourRepository tourRepository;

    @Override
    public void create(Tour tour) {
        tourRepository.create(tour);
    }

    @Override
    public void update(Tour tour) {
        tourRepository.update(tour);
    }

    @Override
    public void delete(Tour tour) {
        tourRepository.delete(tour);
    }

    @Override
    public List<Tour> findAll() {
        return tourRepository.findAll();
    }

    @Override
    public Tour findById(Long id) {
        return tourRepository.findById(id);
    }
}

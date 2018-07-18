package com.epam.agency.service.impl;

import com.epam.agency.domain.Tour;
import com.epam.agency.repository.impl.TourRepository;
import com.epam.agency.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("tourService")
public class TourService implements IService<Tour> {
    @Autowired
    private TourRepository tourRepository;

    @Override
    public void create(Tour entity) {
        tourRepository.create(entity);
    }

    @Override
    public void update(Tour entity) {
        tourRepository.update(entity);
    }

    @Override
    public void delete(Tour entity) {
        tourRepository.delete(entity);

    }

    @Override
    public List<Tour> findAll() {
        return tourRepository.findAll();
    }

    @Override
    public Tour findById(int id) {
        return tourRepository.findById(id);
    }
}

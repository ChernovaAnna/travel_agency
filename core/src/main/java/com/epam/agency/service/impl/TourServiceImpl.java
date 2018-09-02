package com.epam.agency.service.impl;

import com.epam.agency.domain.Tour;
import com.epam.agency.exception.BusinessException;
import com.epam.agency.exception.type.BusinessExceptionCode;
import com.epam.agency.repository.TourRepository;
import com.epam.agency.service.TourService;
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
 * @see TourServiceImpl
 */
@Service("tourService")
@AllArgsConstructor
public class TourServiceImpl implements TourService {

    private TourRepository tourRepository;

    @Override
    public void create(Tour tour) {
        tourRepository.save(tour);
    }

    @Override
    public void update(Tour tour) {
        tourRepository.save(tour);
    }

    @Override
    public void delete(Tour tour) {
        tourRepository.delete(tour);
    }

    @Override
    public List<Tour> findAll() {
        List<Tour> tours = Lists.newArrayList(tourRepository.findAll());
        if (tours.isEmpty()) {
            throw new BusinessException(BusinessExceptionCode.NO_TOURS_FOUND);
        }
        return tours;
    }

    @Override
    public Tour findById(Long id) {
        return tourRepository.findById(id).orElseThrow(() -> new BusinessException(BusinessExceptionCode.TOUR_NOT_FOUND));
    }
}

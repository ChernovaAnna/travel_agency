package com.epam.agency.service;

import com.epam.agency.domain.*;
import com.epam.agency.repository.impl.TourRepository;
import com.epam.agency.service.impl.TourService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class TourServiceTest {
    @InjectMocks
    private TourService tourService;
    @Mock
    private TourRepository tourRepository;
    private Tour tour;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        tour = new Tour();
        tour.setPhoto("tour.jpg");
        tour.setDate(LocalDate.of(2018,Month.APRIL,30));
        tour.setDuration(4);
        tour.setDescription("Welcome!");
        tour.setCost(34);
        tour.setTourType(TourType.CRUISE);
        tour.setHotel(new Hotel());
        tour.setCountry(new Country());
    }

    @Test
    public void testCreateTour() {
        tourService.create(tour);
        verify(tourRepository).create(tour);
    }

    @Test
    public void testDeleteTour() {
        tourService.delete(tour);
        verify(tourRepository).delete(tour);
    }

    @Test
    public void testUpdateTour() {
        tourService.update(tour);
        verify(tourRepository).update(tour);
    }

    @Test
    public void testFindAllTours() {
        when(tourRepository.findAll()).thenReturn(new ArrayList<>());
        List<Tour> tours = tourService.findAll();
        verify(tourRepository).findAll();
        assertThat(tours, is(notNullValue()));
    }

    @Test
    public void testFindTourById() {
        when(tourRepository.findById(0)).thenReturn(tour);
        Tour tour = tourService.findById(0);
        verify(tourRepository).findById(0);
        assertThat(tour, is(notNullValue()));
    }
}

package com.epam.agency.repository;

import com.epam.agency.config.TestConfig;
import com.epam.agency.domain.Feature;
import com.epam.agency.domain.Tour;
import com.epam.agency.domain.TourType;
import com.epam.agency.repository.impl.TourRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class TourRepositoryTest {
    @Mock
    private TourRepository tourRepositoryMocked;

    @Autowired
    private TourRepository tourRepository;
    private AbstractApplicationContext context;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        context = new AnnotationConfigApplicationContext();
        context.getEnvironment().setActiveProfiles("development");
        ((AnnotationConfigApplicationContext) context).register(TestConfig.class);
        context.refresh();
        tourRepository = (TourRepository) context.getBean("tourRepository");
    }

    @After
    public void destroy() {
        tourRepository = null;
        context.close();
    }

    @Test
    public void testCreateTour() {
        tourRepository.create((Tour) context.getBean("tourForAdd"));
        assertThat(tourRepository.findById(4), is(notNullValue()));
        assertThat(tourRepository.findById(4).getPhoto(), is("tour.jpg"));
        assertThat(tourRepository.findById(4).getDuration(), is(4));
        assertThat(tourRepository.findById(4).getCost(), is(34.0));
        assertThat(tourRepository.findById(4).getTourType(), is(TourType.CRUISE));
    }

    @Test
    public void testUpdateTour() {
        Tour tour = (Tour) (context.getBean("tourForUpdate"));
        tour.setPhoto("newtour.jpg");
        tour.setDescription("beautiful landscape.");
        tour.setDuration(30);
        tour.setCost(10);
        tour.setTourType(TourType.ESCORTED);
        tourRepository.update(tour);
        assertThat(tourRepository.findById(2), is(notNullValue()));
        assertThat(tourRepository.findById(2).getPhoto(), is("newtour.jpg"));
        assertThat(tourRepository.findById(2).getDescription(), is("beautiful landscape."));
        assertThat(tourRepository.findById(2).getDuration(), is(30));
        assertThat(tourRepository.findById(2).getCost(), is(10.0));
        assertThat(tourRepository.findById(2).getTourType(), is(TourType.ESCORTED));

    }

    @Test
    public void testDeleteTour() {
        Tour Tour = new Tour();
        tourRepositoryMocked.delete(Tour);
        verify(tourRepositoryMocked).delete(Tour);
    }

    @Test
    public void testFindAllTours() {
        List<Tour> Tours = tourRepository.findAll();
        assertThat(Tours.size(),is(3));
    }

    @Test
    public void testFindTourById() {
        Tour Tour = tourRepository.findById(2);
        assertThat(tourRepository.findById(2), is(notNullValue()));
        assertThat(tourRepository.findById(2).getPhoto(), is("meovd.jpg"));
        assertThat(tourRepository.findById(2).getDescription(), is("Etiam faucibus cursus urna. Ut tellus. Nulla ut erat id mauris vulputate elementum. Nullam varius."));
        assertThat(tourRepository.findById(2).getDuration(), is(72));
        assertThat(tourRepository.findById(2).getCost(), is(677.0));
        assertThat(tourRepository.findById(2).getTourType(), is(TourType.BUS));
    }

}

package com.epam.agency.config;

import com.epam.agency.domain.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

/**
 * Initialize beans for application tests.
 *
 * @author Hanna_Charnova
 * @version 1.0
 */

@Configuration
public class InitBean {

    @Bean(name = "reviewForAdd")
    public Review initReviewForAdd() {
        Review review = new Review();
        review.setDate(LocalDate.of(2018, Month.APRIL, 30));
        review.setText("Excellent.");
        review.setClient(initClientForUpdate());
        review.setTour(initTourForUpdate());
        return review;
    }


    @Bean(name = "reviewForUpdate")
    public Review initReviewForUpdate() {
        Review review = new Review();
        review.setId(2);
        review.setDate(LocalDate.of(2018, Month.APRIL, 30));
        review.setText("In quis justo. Maecenas rhoncus aliquam lacus. Morbi quis tortor id nulla ultrices aliquet.");
        review.setClient(initClientForUpdate());
        review.setTour(initTourForUpdate());
        return review;
    }

    @Bean(name = "hotelForAdd")
    public Hotel initHotelForAdd() {
        Hotel hotel = new Hotel();
        hotel.setName("Hilton");
        hotel.setStars(5);
        hotel.setWebsite("hilton.com");
        hotel.setLalitude(54.3);
        hotel.setLongitude(53.4);
        List<Feature> features = new ArrayList<>();
        features.add(Feature.AIRPORT_TRANSFER);
        features.add(Feature.BABYSITTING_SERVICE);
        hotel.setFeature(features);
        return hotel;
    }

    @Bean(name = "hotelForUpdate")
    public Hotel initHotelForUpdate() {
        Hotel hotel = new Hotel();
        hotel.setId(2L);
        hotel.setName("Welch Inc");
        hotel.setStars(2);
        hotel.setWebsite("https://tiny.cc");
        hotel.setLalitude(1.3350205);
        hotel.setLongitude(34.3976356);
        List<Feature> features = new ArrayList<>();
        features.add(Feature.FITNESS_CENTER);
        hotel.setFeature(features);
        return hotel;
    }

    @Bean(name = "tourForAdd")
    public Tour initTourForAdd() {
        Tour tour = new Tour();
        tour.setPhoto("tour.jpg");
        tour.setDate(LocalDate.of(2018, Month.APRIL, 30));
        tour.setDuration(4);
        tour.setDescription("Welcome!");
        tour.setCost(34);
        tour.setTourType(TourType.CRUISE);
        tour.setHotel(initHotelForUpdate());
        tour.setCountry(initCountryForUpdate());
        return tour;
    }

    @Bean(name = "tourForUpdate")
    public Tour initTourForUpdate() {
        Tour tour = new Tour();
        tour.setId(2L);
        tour.setPhoto("meovd.jpg");
        tour.setDate(LocalDate.of(2017, Month.AUGUST, 16));
        tour.setDuration(72);
        tour.setDescription("Etiam faucibus cursus urna. Ut tellus. Nulla ut erat id mauris vulputate elementum. Nullam varius.");
        tour.setCost(677.1);
        tour.setTourType(TourType.BUS);
        tour.setHotel(initHotelForUpdate());
        tour.setCountry(initCountryForUpdate());
        return tour;
    }


    @Bean(name = "countryForAdd")
    public Country initCountryForAdd() {
        Country country = new Country();
        country.setName("Ukraine");
        return country;
    }

    @Bean(name = "countryForUpdate")
    public Country initCountryForUpdate() {
        Country country = new Country();
        country.setId(2L);
        country.setName("China");
        return country;
    }


    @Bean(name = "clientForAdd")
    public Client initClientForAdd() {
        Client client = new Client();
        client.setLogin("client");
        client.setPassword("password");
        return client;
    }

    @Bean(name = "clientForUpdate")
    public Client initClientForUpdate() {
        Client client = new Client();
        client.setId(2L);
        client.setLogin("iubsdall1");
        client.setPassword("eandersen1");
        return client;
    }

}

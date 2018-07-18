package com.epam.agency;

import com.epam.agency.config.AppConfig;
import com.epam.agency.domain.*;
import com.epam.agency.service.impl.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        TourService tourService = (TourService) context.getBean("tourService");
        CountryService countryService = (CountryService) context.getBean("countryService");
        HotelService hotelService = (HotelService) context.getBean("hotelService");
        ReviewService reviewService = (ReviewService) context.getBean("reviewService");
        ClientService clientService = (ClientService) context.getBean("clientService");
        //        List<Feature> feature = new ArrayList<>();
//        feature.add(Feature.BUSINESS_CENTER);
//        feature.add(Feature.AIRPORT_TRANSFER);
//        Hotel newHotel = new Hotel();
//        newHotel.setName("hot");
//        newHotel.setStars(4);
//        newHotel.setWebsite("hot.com");
//        newHotel.setLalitude(34);
//        newHotel.setLongitude(45);
//        newHotel.setFeature(feature);
//        hotelService.create(newHotel);
//        List<Tour> tours =tourService.findAll();
//        for(Tour tour:tours){
//            System.out.println(tour);
//            Hotel.setPassword("Hotel");
//            HotelService.update(Hotel);
//            if(hotel.getId()==4){
//                hotel.setName("updated");
//                hotelService.update(hotel);
//            }
//        }
////        List<Hotel> delhotels =hotelService.findAll();
////        for(Hotel hotel:delhotels){
////            System.out.println(hotel);
////        }
////        System.out.println(hotel);
////        List<Country> countries =countryService.findAll();
////        for(Country country:countries) {
////            if(country.getId()==4){
////                country.setName("USA");
////                countryService.update(country);
////            }
////        }
//        List<Review> reviews =reviewService.findAll();
//        for(Review review:reviews) {
//            System.out.println(reviewService.findById(3));
////        }
//        tourService.delete(tourService.findById(1));
//        Tour tour=new Tour();
//        tour.setPhoto("ttt");
//        tour.setDate(LocalDate.parse("2017-09-03"));
//        tour.setDuration(5);
//        tour.setDescription("klevo");
//        tour.setCost(39.4);
//        tour.setTourType(TourType.EXTREME);
//        tour.setCountry(countryService.findById(1));
//        tour.setHotel(hotelService.findById(6));
//        tourService.create(tour);
        List<Client> clients=clientService.findAll();
        for(Client client:clients){
            System.out.println(client);
        }

    }
}

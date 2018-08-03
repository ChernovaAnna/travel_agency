//package com.epam.agency.service;
//
//import com.epam.agency.domain.Feature;
//import com.epam.agency.domain.Hotel;
//import com.epam.agency.repository.jpa.HotelRepository;
//import com.epam.agency.service.jpa.HotelService;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.mockito.runners.MockitoJUnitRunner;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.hamcrest.CoreMatchers.is;
//import static org.hamcrest.CoreMatchers.notNullValue;
//import static org.junit.Assert.assertThat;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//
//
//@RunWith(MockitoJUnitRunner.class)
//public class HotelServiceTest {
//    @InjectMocks
//    private HotelService hotelService;
//    @Mock
//    private HotelRepository hotelRepository;
//    private Hotel hotel;
//
//    @Before
//    public void init() {
//        MockitoAnnotations.initMocks(this);
//        hotel = new Hotel();
//        hotel.setName("Hilton");
//        hotel.setStars(5);
//        hotel.setWebsite("hilton.com");
//        hotel.setLalitude(54.3);
//        hotel.setLongitude(53.4);
//        List<Feature> features = new ArrayList<>();
//        features.add(Feature.AIRPORT_TRANSFER);
//        hotel.setFeature(features);
//    }
//
//    @Test
//    public void testCreateHotel() {
//        hotelService.create(hotel);
//        verify(hotelRepository).create(hotel);
//    }
//
//    @Test
//    public void testDeleteHotel() {
//        hotelService.delete(hotel);
//        verify(hotelRepository).delete(hotel);
//    }
//
//    @Test
//    public void testUpdateHotel() {
//        hotelService.update(hotel);
//        verify(hotelRepository).update(hotel);
//    }
//
//    @Test
//    public void testFindAllHotels() {
//        when(hotelRepository.findAll()).thenReturn(new ArrayList<>());
//        List<Hotel> countries = hotelService.findAll();
//        verify(hotelRepository).findAll();
//        assertThat(countries, is(notNullValue()));
//    }
//
//    @Test
//    public void testFindHotelById() {
//        when(hotelRepository.findById(0)).thenReturn(hotel);
//        Hotel hotel = hotelService.findById(0);
//        verify(hotelRepository).findById(0);
//        assertThat(hotel, is(notNullValue()));
//    }
//}

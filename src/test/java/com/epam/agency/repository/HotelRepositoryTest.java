//package com.epam.agency.repository;
//
//import com.epam.agency.config.TestConfig;
//import com.epam.agency.domain.Country;
//import com.epam.agency.domain.Hotel;
//import com.epam.agency.repository.jpa.CountryRepository;
//import com.epam.agency.repository.jpa.HotelRepository;
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.mockito.runners.MockitoJUnitRunner;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//import org.springframework.context.support.AbstractApplicationContext;
//
//import java.util.List;
//
//import static org.hamcrest.CoreMatchers.is;
//import static org.hamcrest.CoreMatchers.notNullValue;
//import static org.junit.Assert.assertThat;
//import static org.mockito.Mockito.verify;
//
//@RunWith(MockitoJUnitRunner.class)
//public class HotelRepositoryTest {
//    @Mock
//    private HotelRepository hotelRepositoryMocked;
//
//    @Autowired
//    private HotelRepository hotelRepository;
//    private AbstractApplicationContext context;
//
//    @Before
//    public void init() {
//        MockitoAnnotations.initMocks(this);
//        context = new AnnotationConfigApplicationContext();
//        context.getEnvironment().setActiveProfiles("development");
//        ((AnnotationConfigApplicationContext) context).register(TestConfig.class);
//        context.refresh();
//        hotelRepository = (HotelRepository) context.getBean("hotelRepository");
//    }
//
//    @After
//    public void destroy() {
//        hotelRepository = null;
//        context.close();
//    }
//
//    @Test
//    public void testCreateHotel() {
//        hotelRepository.create((Hotel) context.getBean("hotelForAdd"));
//        assertThat(hotelRepository.findById(4), is(notNullValue()));
//        assertThat(hotelRepository.findById(4).getName(), is("Hilton"));
//    }
//
//    @Test
//    public void testUpdateHotel() {
//        Hotel hotel = (Hotel) (context.getBean("hotelForUpdate"));
//        hotel.setName("Ritz");
//        hotelRepository.update(hotel);
//        assertThat(hotelRepository.findById(2), is(notNullValue()));
//        assertThat(hotelRepository.findById(2).getName(), is("Ritz"));
//    }
//
//    @Test
//    public void testDeleteHotel() {
//        Hotel hotel = new Hotel();
//        hotelRepositoryMocked.delete(hotel);
//        verify(hotelRepositoryMocked).delete(hotel);
//    }
//
//    @Test
//    public void testFindAllHotels() {
//        List<Hotel> hotels = hotelRepository.findAll();
//        assertThat(hotels.size(),is(3));
//    }
//
//    @Test
//    public void testFindHotelById() {
//        Hotel hotel = hotelRepository.findById(2);
//        assertThat(hotel.getName(),is("Welch Inc"));
//    }
//
//}

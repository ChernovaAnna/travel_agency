//package com.epam.agency.service;
//
//import com.epam.agency.domain.Country;
//import com.epam.agency.repository.jpa.CountryRepository;
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
//public class CountryServiceTest {
//    @InjectMocks
//    private CountryService countryService;
//    @Mock
//    private CountryRepository countryRepository;
//    private Country country;
//
//    @Before
//    public void init() {
//        MockitoAnnotations.initMocks(this);
//        country = new Country();
//        country.setName("Poland");
//    }
//
//    @Test
//    public void testCreateCountry() {
//        countryService.create(country);
//        verify(countryRepository).create(country);
//    }
//
//    @Test
//    public void testDeleteCountry() {
//        countryService.delete(country);
//        verify(countryRepository).delete(country);
//    }
//
//    @Test
//    public void testUpdateCountry() {
//        countryService.update(country);
//        verify(countryRepository).update(country);
//    }
//
//    @Test
//    public void testFindAllCountries() {
//        when(countryRepository.findAll()).thenReturn(new ArrayList<>());
//        List<Country> countries = countryService.findAll();
//        verify(countryRepository).findAll();
//        assertThat(countries, is(notNullValue()));
//    }
//
//    @Test
//    public void testFinCountryById() {
//        when(countryRepository.findById(0L)).thenReturn(country);
//        Country country = countryService.findById(0L);
//        verify(countryRepository).findById(0L);
//        assertThat(country, is(notNullValue()));
//    }
//}

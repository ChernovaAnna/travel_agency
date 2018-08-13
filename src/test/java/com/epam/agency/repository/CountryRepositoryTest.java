//package com.epam.agency.repository;
//
//import com.epam.agency.config.TestConfig;
//import com.epam.agency.domain.Country;
//import com.epam.agency.repository.jpa.CountryRepository;
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
//public class CountryRepositoryTest {
//    @Mock
//    private CountryRepository countryRepositoryMocked;
//
//    @Autowired
//    private CountryRepository countryRepository;
//    private AbstractApplicationContext context;
//
//    @Before
//    public void init() {
//        MockitoAnnotations.initMocks(this);
//        context = new AnnotationConfigApplicationContext();
//        context.getEnvironment().setActiveProfiles("development");
//        ((AnnotationConfigApplicationContext) context).register(TestConfig.class);
//        context.refresh();
//        countryRepository = (CountryRepository) context.getBean("countryRepository");
//    }
//
//    @After
//    public void destroy() {
//        countryRepository = null;
//        context.close();
//    }
//
//    @Test
//    public void testCreateCountry() {
//        countryRepository.create((Country) context.getBean("countryForAdd"));
//        assertThat(countryRepository.findById(4), is(notNullValue()));
//        assertThat(countryRepository.findById(4).getName(), is("Ukraine"));
//    }
//
//    @Test
//    public void testUpdateCountry() {
//        Country country = (Country) (context.getBean("countryForUpdate"));
//        country.setName("UK");
//        countryRepository.update(country);
//        assertThat(countryRepository.findById(2), is(notNullValue()));
//        assertThat(countryRepository.findById(2).getName(), is("UK"));
//    }
//
//    @Test
//    public void testDeleteCountry() {
//        Country country = new Country();
//        countryRepositoryMocked.delete(country);
//        verify(countryRepositoryMocked).delete(country);
//    }
//
//    @Test
//    public void testFindAllCountries() {
//        List<Country> countries = countryRepository.findAll();
//        assertThat(countries.size(),is(3));
//    }
//
//    @Test
//    public void testFindCountryById() {
//        Country country = countryRepository.findById(2);
//        assertThat(country.getName(),is("China"));
//    }
//
//}

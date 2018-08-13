package com.epam.agency.service.jpa;

import com.epam.agency.domain.Country;
import com.epam.agency.repository.jpa.CountryRepository;
import com.epam.agency.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implements IService interface and
 * realizes it's methods
 *
 * @author Hanna_Charnova
 * @version 1.0
 * Description of methods:
 * @see IService
 */

@Service("countryService")
public class CountryService implements IService<Country> {
    @Autowired
    private CountryRepository countryRepository;

    @Override
    public void create(Country country) {
        countryRepository.create(country);
    }

    @Override
    public void update(Country country) {
        countryRepository.update(country);
    }

    @Override
    public void delete(Country country) {
        countryRepository.delete(country);
    }

    @Override
    public List<Country> findAll() {
        return countryRepository.findAll();
    }

    @Override
    public Country findById(Long id) {
        return countryRepository.findById(id);
    }
}

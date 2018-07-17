package com.epam.agency.service.impl;

import com.epam.agency.domain.Country;
import com.epam.agency.repository.impl.CountryRepository;
import com.epam.agency.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("countryService")
public class CountryService implements IService<Country> {
    @Autowired
    private CountryRepository countryRepository;

    @Override
    public void create(Country entity) {
        countryRepository.create(entity);
    }

    @Override
    public void update(Country entity) {
        countryRepository.update(entity);
    }

    @Override
    public void delete(Country entity) {
        countryRepository.delete(entity);
    }

    @Override
    public List<Country> findAll() {
        return countryRepository.findAll();
    }

    @Override
    public Country findById(int id) {
        return countryRepository.findById(id);
    }
}

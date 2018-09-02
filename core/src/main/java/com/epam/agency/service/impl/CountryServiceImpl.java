package com.epam.agency.service.impl;

import com.epam.agency.domain.Country;
import com.epam.agency.exception.BusinessException;
import com.epam.agency.exception.type.BusinessExceptionCode;
import com.epam.agency.repository.CountryRepository;
import com.epam.agency.service.CountryService;
import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implements IService interface and
 * realizes it's methods
 *
 * @author Hanna_Charnova
 * @version 1.0
 * Description of methods:
 * @see CountryService
 */
@Service("countryService")
@AllArgsConstructor
public class CountryServiceImpl implements CountryService {

    private CountryRepository countryRepository;

    @Override
    public void create(Country country) {
        countryRepository.save(country);
    }

    @Override
    public void update(Country country) {
        countryRepository.save(country);
    }

    @Override
    public void delete(Country country) {
        countryRepository.delete(country);
    }

    @Override
    public List<Country> findAll() {
        List<Country> countries = Lists.newArrayList(countryRepository.findAll());
        if (countries.isEmpty()) {
            throw new BusinessException(BusinessExceptionCode.NO_COUNTRIES_FOUND);
        }
        return countries;
    }

    @Override
    public Country findById(Long id) {
        return countryRepository.findById(id).orElseThrow(() -> new BusinessException(BusinessExceptionCode.COUNTRY_NOT_FOUND));
    }
}

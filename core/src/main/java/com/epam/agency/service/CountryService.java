package com.epam.agency.service;

import com.epam.agency.domain.Country;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CountryService {
    /**
     * Create Country in the repository.
     *
     * @param country
     */
    void create(Country country);

    /**
     * Update Country from the repository.
     *
     * @param country
     */
    void update(Country country);

    /**
     * Delete Country from the repository
     *
     * @param country
     */
    void delete(Country country);

    /**
     * @return all entities from concrete repository
     */
    List<Country> findAll();

    /**
     * Find Country by id in the repository
     *
     * @param id of Country
     * @return Country with corresponding id
     */
    Country findById(Long id);

}

package com.epam.agency.repository.impl;

import com.epam.agency.domain.Country;
import com.epam.agency.repository.IRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Qualifier("countryRepository")
public class CountryRepository implements IRepository<Country> {
    private final static String FIND_ALL_COUNTRIES = "SELECT * FROM agency.country";
    private final static String FIND_COUNTRY_BY_ID = "SELECT * FROM agency.country WHERE id=?";
    private final static String DELETE_COUNTRY = "DELETE FROM agency.country WHERE id=?";
    private final static String UPDATE_COUNTRY = "UPDATE agency.country SET name=? WHERE id=?";
    private final static String ADD_COUNTRY = "INSERT INTO agency.country (name) VALUES (?)";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void create(Country entity) {
        jdbcTemplate.update(ADD_COUNTRY, entity.getName());
    }

    @Override
    public void update(Country entity) {
        jdbcTemplate.update(UPDATE_COUNTRY, entity.getName(), entity.getId());
    }

    @Override
    public void delete(Country entity) {
        jdbcTemplate.update(DELETE_COUNTRY, entity.getId());
    }

    @Override
    public List<Country> findAll() {
        List<Country> countries = jdbcTemplate.query(FIND_ALL_COUNTRIES, new BeanPropertyRowMapper<>(Country.class));
        return countries;
    }

    @Override
    public Country findById(int id) {
        Country country = jdbcTemplate.queryForObject(FIND_COUNTRY_BY_ID, new Object[]{id}, new BeanPropertyRowMapper<>(Country.class));
        return country;
    }
}

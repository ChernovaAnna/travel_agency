package com.epam.agency.repository.impl;

import com.epam.agency.domain.*;
import com.epam.agency.repository.IRepository;
import com.epam.agency.repository.mapper.HotelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
@Qualifier("hotelRepository")
public class HotelRepository implements IRepository<Hotel> {
    private final static String FIND_ALL_HOTELS = "SELECT * FROM agency.hotel";
    private final static String FIND_HOTEL_BY_ID = "SELECT * FROM agency.hotel WHERE id=?";
    private static final String DELETE_HOTEL = "DELETE FROM agency.hotel WHERE id=?";
    private static final String ADD_HOTEL = "INSERT INTO agency.hotel (name,stars,website,lalitude,longitude,features) VALUES (?,?,?,?,?,?)";
    private static final String UPDATE_HOTEL = "UPDATE agency.hotel SET name=?,stars=?,website=?,lalitude=?,longitude=?,features=? WHERE id=?";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void create(Hotel entity) {
        StringBuilder feature = new StringBuilder();
        entity.getFeature().forEach(item -> {
            feature.append((item).getValue()).append(",");
        });
        jdbcTemplate.update(ADD_HOTEL, entity.getName(), entity.getStars(), entity.getWebsite(), entity.getLalitude(), entity.getLongitude(), feature.toString());
    }

    @Override
    public void update(Hotel entity) {
        StringBuilder feature = new StringBuilder();
        entity.getFeature().forEach(item -> {
            feature.append((item).getValue()).append(",");
        });
        jdbcTemplate.update(UPDATE_HOTEL, entity.getName(), entity.getStars(), entity.getWebsite(), entity.getLalitude(), entity.getLongitude(), feature.toString(),entity.getId());

    }

    @Override
    public void delete(Hotel entity) {
        jdbcTemplate.update(DELETE_HOTEL, entity.getId());
    }

    @Override
    public List<Hotel> findAll() {
        List<Hotel> hotels = jdbcTemplate.query(FIND_ALL_HOTELS, new HotelMapper());
        return hotels;
    }

    @Override
    public Hotel findById(int id) {
        Hotel hotel = jdbcTemplate.queryForObject(FIND_HOTEL_BY_ID, new Object[]{id}, new HotelMapper());
        return hotel;
    }
}

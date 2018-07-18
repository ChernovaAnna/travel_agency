package com.epam.agency.repository.impl;

import com.epam.agency.domain.*;
import com.epam.agency.repository.IRepository;
import com.epam.agency.repository.mapper.HotelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
@Qualifier("hotelRepository")
public class HotelRepository implements IRepository<Hotel> {
    private final static Logger LOGGER = LoggerFactory.getLogger(HotelRepository.class);
    private final static String FIND_ALL_HOTELS = "SELECT * FROM hotel";
    private final static String FIND_HOTEL_BY_ID = "SELECT * FROM hotel WHERE id=?";
    private static final String DELETE_HOTEL = "DELETE FROM hotel WHERE id=?";
    private static final String ADD_HOTEL = "INSERT INTO hotel (name,stars,website,lalitude,longitude,features) VALUES (?,?,?,?,?,?)";
    private static final String UPDATE_HOTEL = "UPDATE hotel SET name=?,stars=?,website=?,lalitude=?,longitude=?,features=? WHERE id=?";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void create(Hotel entity) {
        LOGGER.info("add hotel");
        StringBuilder feature = new StringBuilder();
        entity.getFeature().forEach(item -> {
            feature.append((item).getValue()).append(",");
        });
        jdbcTemplate.update(ADD_HOTEL, entity.getName(), entity.getStars(), entity.getWebsite(), entity.getLalitude(), entity.getLongitude(), feature.toString());
    }

    @Override
    public void update(Hotel entity) {
        LOGGER.info("update hotel");
        StringBuilder feature = new StringBuilder();
        entity.getFeature().forEach(item -> {
            feature.append((item).getValue()).append(",");
        });
        jdbcTemplate.update(UPDATE_HOTEL, entity.getName(), entity.getStars(), entity.getWebsite(), entity.getLalitude(), entity.getLongitude(), feature.toString(),entity.getId());

    }

    @Override
    public void delete(Hotel entity) {
        LOGGER.info("delete hotel");
        jdbcTemplate.update(DELETE_HOTEL, entity.getId());
    }

    @Override
    public List<Hotel> findAll() {
        LOGGER.info("find all hotels");
        List<Hotel> hotels = jdbcTemplate.query(FIND_ALL_HOTELS, new HotelMapper());
        return hotels;
    }

    @Override
    public Hotel findById(int id) {
        LOGGER.info("find hotel by id");
        Hotel hotel = jdbcTemplate.queryForObject(FIND_HOTEL_BY_ID, new Object[]{id}, new HotelMapper());
        return hotel;
    }
}

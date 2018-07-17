package com.epam.agency.repository.impl;

import com.epam.agency.domain.*;
import com.epam.agency.repository.IRepository;
import com.epam.agency.repository.mapper.TourMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@Qualifier("tourRepository")
public class TourRepository implements IRepository<Tour> {
    private final static String FIND_ALL_TOURS = "SELECT t.id, photo,date,duration,description," +
            "cost,tour_type,c.id AS country_id," +
            " c.name AS country_name,h.id AS hotel_id,h.name AS hotel_name,h.stars,h.website,h.lalitude,h.longitude,h.features " +
            "FROM agency.tour t JOIN agency.country c ON t.country_id=c.id " +
            "JOIN agency.hotel h ON t.hotel_id = h.id";
    private final static String FIND_TOUR_BY_ID = "SELECT t.id, photo,date,duration,description," +
            "cost,tour_type,c.id AS country_id," +
            " c.name AS country_name,h.id AS hotel_id,h.name AS hotel_name,h.stars,h.website,h.lalitude,h.longitude,h.features " +
            "FROM agency.tour t JOIN agency.country c ON t.country_id=c.id " +
            "JOIN agency.hotel h ON t.hotel_id = h.id WHERE t.id=?";
    private final static String DELETE_TOUR = "DELETE FROM agency.tour WHERE id=?";
    private final static String UPDATE_TOUR = "UPDATE agency.tour SET photo=?,date=?,duration=?,description=?,cost=?,tour_type=?,hotel_id=?,country_id=? WHERE id=?";
    private final static String ADD_TOUR = "INSERT INTO agency.tour (photo,date,duration,description,cost,tour_type,hotel_id,country_id) VALUES(?,?,?,?,?,?,?,?)";
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void create(Tour entity) {
        jdbcTemplate.update(ADD_TOUR, entity.getPhoto(), entity.getDate(), entity.getDuration(), entity.getDescription(), entity.getCost(), entity.getTourType().getValue(), entity.getHotel().getId(), entity.getCountry().getId());
    }

    @Override
    public void update(Tour entity) {
        jdbcTemplate.update(UPDATE_TOUR, entity.getPhoto(), entity.getDate(), entity.getDuration(), entity.getDescription(), entity.getCost(), entity.getTourType().getValue(), entity.getHotel().getId(), entity.getCountry().getId(), entity.getId());
    }

    @Override
    public void delete(Tour entity) {
        jdbcTemplate.update(DELETE_TOUR, entity.getId());
    }

    @Override
    public List<Tour> findAll() {
        List<Tour> tours = jdbcTemplate.query(FIND_ALL_TOURS, new TourMapper());
        return tours;
    }

    @Override
    public Tour findById(int id) {
        Tour tour = jdbcTemplate.queryForObject(FIND_TOUR_BY_ID, new Object[]{id}, new TourMapper());
        return tour;

    }
}

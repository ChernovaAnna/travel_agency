package com.epam.agency.repository.mapper;

import com.epam.agency.domain.Feature;
import com.epam.agency.domain.Hotel;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Implements RowMapper interface and
 * handle information about hotels
 * fetched from database.
 *
 * Description of methods:
 * @see RowMapper
 *
 * @author Hanna_Charnova
 * @version 1.0
 */


public class HotelMapper implements RowMapper<Hotel> {

    /**
     * Create Hotel object and initialize it
     * by data from database
     *
     * @param resultSet
     * @param i
     * @return Hotel object initialized by information fetched from database
     * @throws SQLException when appeal to resultSet is incorrect
     */
    @Override
    public Hotel mapRow(ResultSet resultSet, int i) throws SQLException {
        Hotel hotel = new Hotel();
        hotel.setId(resultSet.getLong("id"));
        hotel.setName(resultSet.getString("name"));
        hotel.setStars(resultSet.getInt("stars"));
        hotel.setWebsite(resultSet.getString("website"));
        hotel.setLalitude(resultSet.getDouble("lalitude"));
        hotel.setLongitude(resultSet.getDouble("longitude"));
        String[] featuresStr = resultSet.getString("features").split(",");
        List<Feature> features = new ArrayList<>();
        for (String feature : featuresStr) {
            features.add(Feature.valueOf(feature.toUpperCase().replace(' ', '_')));
        }
        hotel.setFeature(features);
        return hotel;

    }
}

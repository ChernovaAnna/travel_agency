package com.epam.agency.repository.mapper;

import com.epam.agency.domain.*;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Implements RowMapper interface and
 * handle information about tours
 * fetched from database.
 *
 * Description of methods:
 * @see RowMapper
 *
 * @author Hanna_Charnova
 * @version 1.0
 */

public class TourMapper implements RowMapper<Tour> {

    /**
     * Create Tour object and initialize it
     * by data from database
     *
     * @param resultSet
     * @param i
     * @return Tour object initialized by information fetched from database
     * @throws SQLException when appeal to resultSet is incorrect
     */
    @Override
    public Tour mapRow(ResultSet resultSet, int i) throws SQLException {
        Tour tour = new Tour();
        tour.setId(resultSet.getLong("id"));
        tour.setPhoto(resultSet.getString("photo"));
        tour.setDate(resultSet.getDate("date").toLocalDate());
        tour.setDuration(resultSet.getInt("duration"));
        tour.setDescription(resultSet.getString("description"));
        tour.setCost(resultSet.getDouble("cost"));
        tour.setTourType(TourType.valueOf(resultSet.getString("tour_type").toUpperCase()));

        Hotel hotel = new Hotel();
        hotel.setId(resultSet.getLong("hotel_id"));
        hotel.setName(resultSet.getString("hotel_name"));
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
        tour.setHotel(hotel);

        Country country = new Country();
        country.setId(resultSet.getLong("country_id"));
        country.setName(resultSet.getString("country_name"));
        tour.setCountry(country);
        return tour;
    }
}

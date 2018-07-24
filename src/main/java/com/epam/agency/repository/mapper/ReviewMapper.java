package com.epam.agency.repository.mapper;

import com.epam.agency.domain.*;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Implements RowMapper interface and
 * handle information about reviews
 * fetched from database.
 *
 * Description of methods:
 * @see RowMapper
 *
 * @author Hanna_Charnova
 * @version 1.0
 */

public class ReviewMapper implements RowMapper<Review> {

    /**
     * Create Review object and initialize it
     * by data from database
     *
     * @param resultSet
     * @param i
     * @return Review object initialized by information fetched from database
     * @throws SQLException when appeal to resultSet is incorrect
     */
    @Override
    public Review mapRow(ResultSet resultSet, int i) throws SQLException {
        Review review = new Review();
        review.setId(resultSet.getInt("id"));
        review.setDate(resultSet.getDate("review_date").toLocalDate());
        review.setText(resultSet.getString("text"));

        Client client = new Client();
        client.setId(resultSet.getInt("client_id"));
        client.setLogin(resultSet.getString("login"));
        client.setPassword(resultSet.getString("password"));
        review.setClient(client);

        Tour tour = new Tour();
        tour.setId(resultSet.getInt("tour_id"));
        tour.setPhoto(resultSet.getString("photo"));
        tour.setDate(resultSet.getDate("tour_date").toLocalDate());
        tour.setDuration(resultSet.getInt("duration"));
        tour.setDescription(resultSet.getString("description"));
        tour.setCost(resultSet.getDouble("cost"));
        tour.setTourType(TourType.valueOf(resultSet.getString("tour_type").toUpperCase()));

        Hotel hotel = new Hotel();
        hotel.setId(resultSet.getInt("hotel_id"));
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
        country.setId(resultSet.getInt("country_id"));
        country.setName(resultSet.getString("country_name"));
        tour.setCountry(country);
        review.setTour(tour);

        return review;
    }
}

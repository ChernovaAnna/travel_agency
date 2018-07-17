package com.epam.agency.repository.mapper;

import com.epam.agency.domain.Feature;
import com.epam.agency.domain.Hotel;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class HotelMapper implements RowMapper<Hotel> {

    @Override
    public Hotel mapRow(ResultSet resultSet, int i) throws SQLException {
        Hotel hotel = new Hotel();
        hotel.setId(resultSet.getInt("id"));
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

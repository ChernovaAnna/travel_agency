package com.epam.agency.repository.impl;
import com.epam.agency.domain.Review;
import com.epam.agency.repository.IRepository;
import com.epam.agency.repository.mapper.ReviewMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Qualifier("reviewRepository")
public class ReviewRepository implements IRepository<Review> {
    private final static Logger LOGGER = LoggerFactory.getLogger(ReviewRepository.class);
    private final static String FIND_ALL_REVIEWS = "SELECT r.id,r.date AS review_date,r.text,t.id AS tour_id, t.photo,t.date AS tour_date,t.duration,t.description, " +
            "t.cost,t.tour_type,c.id AS country_id," +
            " c.name AS country_name,h.id AS hotel_id,h.name AS hotel_name,h.stars,h.website,h.lalitude,h.longitude,h.features, " +
            "cl.id AS client_id, cl.login,cl.password "+
            "FROM review r JOIN agency.client cl ON r.client_id=cl.id "+
            "JOIN tour t ON r.tour_id=t.id "+
            "JOIN hotel h ON t.hotel_id = h.id "+
            "JOIN country c ON t.country_id=c.id";
    private final static String FIND_REVIEW_BY_ID = "SELECT r.id,r.date AS review_date,r.text,t.id AS tour_id, t.photo,t.date AS tour_date,t.duration,t.description, " +
            "t.cost,t.tour_type,c.id AS country_id," +
            " c.name AS country_name,h.id AS hotel_id,h.name AS hotel_name,h.stars,h.website,h.lalitude,h.longitude,h.features, " +
            "cl.id AS client_id, cl.login,cl.password "+
            "FROM review r JOIN client cl ON r.client_id=cl.id "+
            "JOIN tour t ON r.tour_id=t.id "+
            "JOIN hotel h ON t.hotel_id = h.id "+
            "JOIN country c ON t.country_id=c.id WHERE r.id=?";
    private static final String DELETE_REVIEW = "DELETE FROM review WHERE id=?";
    private static final String ADD_REVIEW = "INSERT INTO review (date,text,client_id,tour_id) VALUES (?,?,?,?)";
    private static final String UPDATE_REVIEW = "UPDATE review SET date=?,text=?,client_id=?,tour_id=? WHERE id=?";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void create(Review entity) {
        LOGGER.info("add review");
        jdbcTemplate.update(ADD_REVIEW, entity.getDate(), entity.getText(), entity.getClient().getId(), entity.getTour().getId());
    }

    @Override
    public void update(Review entity) {
        LOGGER.info("update review");
        jdbcTemplate.update(UPDATE_REVIEW, entity.getDate(), entity.getText(), entity.getClient().getId(), entity.getTour().getId(),entity.getId());

    }

    @Override
    public void delete(Review entity) {
        LOGGER.info("delete review");
        jdbcTemplate.update(DELETE_REVIEW, entity.getId());
    }

    @Override
    public List<Review> findAll() {
        LOGGER.info("find all reviews");
        List<Review> reviews = jdbcTemplate.query(FIND_ALL_REVIEWS, new ReviewMapper());
        return reviews;
    }

    @Override
    public Review findById(int id) {
        LOGGER.info("find review by id");
        Review review = jdbcTemplate.queryForObject(FIND_REVIEW_BY_ID, new Object[]{id}, new ReviewMapper());
        return review;
    }
}

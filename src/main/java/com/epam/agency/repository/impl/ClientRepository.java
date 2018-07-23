package com.epam.agency.repository.impl;

import com.epam.agency.domain.Client;
import com.epam.agency.domain.Review;
import com.epam.agency.domain.Tour;
import com.epam.agency.repository.IRepository;
import com.epam.agency.repository.mapper.ReviewMapper;
import com.epam.agency.repository.mapper.TourMapper;
import org.postgresql.util.PSQLException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Qualifier("clientRepository")
public class ClientRepository implements IRepository<Client> {
    private final static Logger LOGGER = LoggerFactory.getLogger(ClientRepository.class);
    private final static String FIND_ALL_CLIENTS = "SELECT id, login,password FROM client";
    private final static String ADD_CLIENT = "INSERT INTO client (login,password) VALUES (?,?)";
    private final static String UPDATE_CLIENT = "UPDATE client SET login = ?,password=? WHERE id=?";
    private final static String DELETE_CLIENT = "DELETE FROM client WHERE id=?";
    private final static String FIND_CLIENT_BY_ID = "SELECT id, login,password FROM client WHERE id=?";
    private final static String FIND_TOUR_BY_CLIENT_ID = "SELECT t.id, t.photo,t.date,t.duration,t.description," +
            "t.cost,t.tour_type,c.id AS country_id," +
            "c.name AS country_name,h.id AS hotel_id,h.name AS hotel_name,h.stars,h.website,h.lalitude,h.longitude,h.features " +
            "FROM tour t " +
            "JOIN client_tour ct ON t.id=ct.tour_id  JOIN client cl ON ct.client_id=cl.id "+
            "JOIN country c ON t.country_id=c.id " +
            "JOIN hotel h ON t.hotel_id = h.id WHERE cl.id=?";
    private final static String FIND_REVIEW_BY_CLIENT_ID = "SELECT r.id,r.date AS review_date,r.text,t.id AS tour_id, t.photo,t.date AS tour_date,t.duration,t.description, " +
            "t.cost,t.tour_type,c.id AS country_id," +
            " c.name AS country_name,h.id AS hotel_id,h.name AS hotel_name,h.stars,h.website,h.lalitude,h.longitude,h.features, " +
            "cl.id AS client_id, cl.login,cl.password "+
            "FROM review r JOIN client cl ON r.client_id=cl.id "+
            "JOIN tour t ON r.tour_id=t.id "+
            "JOIN hotel h ON t.hotel_id = h.id "+
            "JOIN country c ON t.country_id=c.id WHERE cl.id=?";



    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void create(Client entity) {
        LOGGER.info("add client");
        jdbcTemplate.update(ADD_CLIENT, entity.getLogin(), entity.getPassword());
    }

    @Override
    public void update(Client entity) {
        LOGGER.info("update client");
        jdbcTemplate.update(UPDATE_CLIENT, entity.getLogin(), entity.getPassword(), entity.getId());
    }

    @Override
    public void delete(Client entity) {
        LOGGER.info("delete client");
        jdbcTemplate.update(DELETE_CLIENT, entity.getId());
    }

    @Override
    public List<Client> findAll() {
        LOGGER.info("find all clients");
        List<Client> clients = jdbcTemplate.query(FIND_ALL_CLIENTS, new BeanPropertyRowMapper(Client.class));
        return clients;
    }

    @Override
    public Client findById(int id) {
        LOGGER.info("find client by id");
        Client client = (Client) jdbcTemplate.queryForObject(FIND_CLIENT_BY_ID, new Object[]{id}, new BeanPropertyRowMapper(Client.class));
        List<Tour> tours = jdbcTemplate.query(FIND_TOUR_BY_CLIENT_ID, new Object[]{id}, new TourMapper());
        List<Review> reviews = jdbcTemplate.query(FIND_REVIEW_BY_CLIENT_ID, new Object[]{id}, new ReviewMapper());
        client.setTours(tours);
        client.setReviews(reviews);
        return client;
    }
}

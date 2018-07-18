package com.epam.agency.repository.impl;

import com.epam.agency.domain.Client;
import com.epam.agency.repository.IRepository;
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
    private final static String FIND_ALL_CLIENTS = "SELECT * FROM client";
    private final static String ADD_CLIENT = "INSERT INTO client (login,password) VALUES (?,?)";
    private final static String UPDATE_CLIENT = "UPDATE client SET login = ?,password=? WHERE id=?";
    private final static String DELETE_CLIENT = "DELETE FROM client WHERE id=?";
    private final static String FIND_CLIENT_BY_ID = "SELECT * FROM client WHERE id=?";
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
        return client;
    }
}

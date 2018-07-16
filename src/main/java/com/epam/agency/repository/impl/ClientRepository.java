package com.epam.agency.repository.impl;

import com.epam.agency.domain.Client;
import com.epam.agency.repository.IRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Qualifier("clientRepository")
public class ClientRepository implements IRepository<Client> {
    private final static String FIND_ALL_CLIENTS = "SELECT * FROM agency.client";
    private final static String ADD_CLIENT = "INSERT INTO agency.client (login,password) VALUES (?,?)";
    private final static String UPDATE_CLIENT = "UPDATE agency.client SET login = ?,password=? WHERE id=?";
    private final static String DELETE_CLIENT = "DELETE FROM agency.client WHERE id=?";
    private final static String FIND_CLIENT_BY_ID = "SELECT * FROM agency.client WHERE id=?";
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void create(Client entity) {
        jdbcTemplate.update(ADD_CLIENT, entity.getLogin(), entity.getPassword());
    }

    @Override
    public void update(Client entity) {
        jdbcTemplate.update(UPDATE_CLIENT, entity.getLogin(), entity.getPassword(), entity.getId());
    }

    @Override
    public void delete(Client entity) {
        jdbcTemplate.update(DELETE_CLIENT, entity.getId());
    }

    @Override
    public List<Client> findAll() {
        List<Client> clients = jdbcTemplate.query(FIND_ALL_CLIENTS, new BeanPropertyRowMapper(Client.class));
        return clients;
    }

    @Override
    public Client findById(int id) {
        Client client = (Client) jdbcTemplate.queryForObject(FIND_CLIENT_BY_ID, new Object[]{id}, new BeanPropertyRowMapper(Client.class));
        return client;
    }
}

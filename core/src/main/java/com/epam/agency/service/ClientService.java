package com.epam.agency.service;


import com.epam.agency.domain.Client;
import org.springframework.stereotype.Service;

@Service
public interface ClientService {
    /**
     * Create client in the repository.
     *
     * @param client
     */
    Client create(Client client);

    /**
     * Update client from the repository.
     *
     * @param client
     */
    void update(Client client);

    /**
     * Delete client from the repository
     *
     * @param client
     */
    void delete(Client client);

    /**
     * @return all entities from concrete repository
     */
    Iterable<Client> findAll();

    /**
     * Find client by id in the repository
     *
     * @param id of client
     * @return client with corresponding id
     */
    Client findById(Long id);

    Client findByLogin(String login);

}

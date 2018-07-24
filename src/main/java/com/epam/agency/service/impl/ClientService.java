package com.epam.agency.service.impl;

import com.epam.agency.domain.Client;
import com.epam.agency.repository.impl.ClientRepository;
import com.epam.agency.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implements IService interface and
 * realizes it's methods
 *
 * @author Hanna_Charnova
 * @version 1.0
 * Description of methods:
 * @see IService
 */

@Service("clientService")
public class ClientService implements IService<Client> {
    @Autowired
    private ClientRepository clientRepository;

    @Override
    public void create(Client client) {
        clientRepository.create(client);
    }

    @Override
    public void update(Client client) {
        clientRepository.update(client);
    }

    @Override
    public void delete(Client client) {
        clientRepository.delete(client);
    }

    @Override
    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    @Override
    public Client findById(int id) {
        return clientRepository.findById(id);
    }
}

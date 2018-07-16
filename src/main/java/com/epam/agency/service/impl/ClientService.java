package com.epam.agency.service.impl;

import com.epam.agency.domain.Client;
import com.epam.agency.repository.impl.ClientRepository;
import com.epam.agency.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("clientService")
public class ClientService implements IService<Client> {
    @Autowired
    private ClientRepository clientRepository;

    @Override
    public void create(Client entity) {
        clientRepository.create(entity);
    }

    @Override
    public void update(Client entity) {
        clientRepository.update(entity);
    }

    @Override
    public void delete(Client entity) {
        clientRepository.delete(entity);
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

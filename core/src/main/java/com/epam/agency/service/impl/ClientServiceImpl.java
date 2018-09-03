package com.epam.agency.service.impl;

import com.epam.agency.domain.Client;
import com.epam.agency.exception.BusinessException;
import com.epam.agency.exception.type.BusinessExceptionCode;
import com.epam.agency.repository.ClientRepository;
import com.epam.agency.service.ClientService;
import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implements IService interface and
 * realizes it's methods
 *
 * @author Hanna_Charnova
 * @version 1.0
 * Description of methods:
 * @see ClientServiceImpl
 */
@Service("clientService")
@AllArgsConstructor
public class ClientServiceImpl implements ClientService {

    private ClientRepository clientRepository;

    @Override
    public Client create(Client client) {
       return clientRepository.save(client);
    }

    @Override
    public void update(Client client) {
        clientRepository.save(client);
    }

    @Override
    public void delete(Client client) {
        clientRepository.delete(client);
    }

    @Override
    public List<Client> findAll() {
        List<Client> clients = Lists.newArrayList(clientRepository.findAll());
        if (clients.isEmpty()) {
            throw new BusinessException(BusinessExceptionCode.NO_USERS_FOUND);
        }
        return clients;
    }

    @Override
    public Client findById(Long id) {
        return clientRepository.findById(id).orElseThrow(() -> new BusinessException(BusinessExceptionCode.USER_NOT_FOUND));
    }

    @Override
    public Client findByLogin(String login) {
        return clientRepository.findByLogin(login).orElseThrow(() -> new BusinessException(BusinessExceptionCode.USER_NOT_FOUND));
    }

}

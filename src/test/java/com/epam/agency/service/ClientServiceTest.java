//package com.epam.agency.service;
//
//import com.epam.agency.domain.Client;
//import com.epam.agency.repository.jpa.ClientRepository;
//import com.epam.agency.service.jpa.ClientService;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.mockito.runners.MockitoJUnitRunner;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.hamcrest.CoreMatchers.is;
//import static org.hamcrest.CoreMatchers.notNullValue;
//import static org.junit.Assert.assertThat;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//
//
//@RunWith(MockitoJUnitRunner.class)
//public class ClientServiceTest {
//    @InjectMocks
//    private ClientService clientService;
//    @Mock
//    private ClientRepository clientRepository;
//    private Client client;
//
//    @Before
//    public void init() {
//        MockitoAnnotations.initMocks(this);
//        client = new Client();
//        client.setLogin("client");
//        client.setPassword("password");
//    }
//
//    @Test
//    public void testCreateClient() {
//        clientService.create(client);
//        verify(clientRepository).create(client);
//    }
//
//    @Test
//    public void testDeleteClient() {
//        clientService.delete(client);
//        verify(clientRepository).delete(client);
//    }
//
//    @Test
//    public void testUpdateClient() {
//        clientService.update(client);
//        verify(clientRepository).update(client);
//    }
//
//    @Test
//    public void testFindAllClients() {
//        when(clientRepository.findAll()).thenReturn(new ArrayList<>());
//        List<Client> clients = clientService.findAll();
//        verify(clientRepository).findAll();
//        assertThat(clients, is(notNullValue()));
//    }
//
//    @Test
//    public void testFindById() {
//        when(clientRepository.findById(0)).thenReturn(client);
//        Client client = clientService.findById(0);
//        verify(clientRepository).findById(0);
//        assertThat(client, is(notNullValue()));
//    }
//}

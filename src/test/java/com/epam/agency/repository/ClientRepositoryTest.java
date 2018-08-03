package com.epam.agency.repository;

import com.epam.agency.config.TestConfig;
import com.epam.agency.domain.Client;
import com.epam.agency.repository.jpa.ClientRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class ClientRepositoryTest {
    @Mock
    private ClientRepository clientRepositoryMocked;

    @Autowired
    private ClientRepository clientRepository;
    private AbstractApplicationContext context;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        context = new AnnotationConfigApplicationContext();
        context.getEnvironment().setActiveProfiles("development","jpaRepository");
        ((AnnotationConfigApplicationContext) context).register(TestConfig.class);
        context.refresh();
        clientRepository = (ClientRepository) context.getBean("clientRepository");
    }

    @After
    public void destroy() {
        clientRepository = null;
        context.close();
    }

    @Test
    public void testCreateClient() {
        clientRepository.create((Client) context.getBean("clientForAdd"));
        assertThat(clientRepository.findById(4L), is(notNullValue()));
        assertThat(clientRepository.findById(4L).getLogin(), is("client"));
    }

    @Test
    public void testUpdateClient() {
        Client client = (Client) (context.getBean("clientForUpdate"));
        client.setPassword("newPassword");
        clientRepository.update(client);
        assertThat(clientRepository.findById(2L), is(notNullValue()));
        assertThat(clientRepository.findById(2L).getLogin(), is("iubsdall1"));
        assertThat(clientRepository.findById(2L).getPassword(), is("newPassword"));
    }

    @Test
    public void testDeleteClient() {
        Client client = new Client();
        clientRepositoryMocked.delete(client);
        verify(clientRepositoryMocked).delete(client);
    }

    @Test
    public void testFindAllClients() {
        List<Client> clients = clientRepository.findAll();
        assertThat(clients.size(), is(3));
    }

    @Test
    public void testFindClientById() {
        Client client = clientRepository.findById(2L);
        assertThat(client.getLogin(), is("iubsdall1"));
        assertThat(client.getPassword(), is("eandersen1"));

    }

}

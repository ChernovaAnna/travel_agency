package com.epam.agency.repository.jpa;

import com.epam.agency.domain.Client;
import com.epam.agency.repository.IRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Implements IRepository interface and
 * realizes it's methods. Used to work with
 * clients' information.
 *
 * @author Hanna_Charnova
 * @version 1.0
 * Description of methods:
 * @see IRepository
 */
@Transactional
@Repository("clientRepository")
public class ClientRepository implements IRepository<Client> {
    private final static Logger LOGGER = LoggerFactory.getLogger(ClientRepository.class);

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void create(Client entity) {
        entityManager.persist(entity);
    }

    @Override
    public void delete(Client entity) {
        Query namedQuery = entityManager.createNamedQuery(Client.DELETE_CLIENT);
        namedQuery.setParameter("id", entity.getId());
        namedQuery.executeUpdate();
    }

    @Override
    public void update(Client entity) {
        entityManager.merge(entity);
    }

    @Override
    public Client findById(Long id) {
        Query namedQuery = entityManager.createNamedQuery(Client.FIND_CLIENT_BY_ID);
        namedQuery.setParameter("id", id);
        return (Client) namedQuery.getSingleResult();
    }

    @Override
    public List<Client> findAll() {
        Query nativeQuery = entityManager.createNativeQuery("SELECT c.id, c.login,c.password FROM Client c", Client.class);
        return nativeQuery.getResultList();
    }
}

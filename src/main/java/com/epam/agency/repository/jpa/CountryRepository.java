package com.epam.agency.repository.jpa;

import com.epam.agency.domain.Country;
import com.epam.agency.repository.IRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Implements IRepository interface and
 * realizes it's methods. Used to work with
 * countries' information.
 *
 * @author Hanna_Charnova
 * @version 1.0
 * Description of methods:
 * @see IRepository
 */

@Transactional
@Repository("countryRepository")
public class CountryRepository implements IRepository<Country> {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void create(Country entity) {
        entityManager.persist(entity);
    }

    @Override
    public void delete(Country entity) {
        Query namedQuery = entityManager.createNamedQuery(Country.DELETE_COUNTRY);
        namedQuery.setParameter("id", entity.getId());
        namedQuery.executeUpdate();
    }

    @Override
    public void update(Country entity) {
        entityManager.merge(entity);
    }

    @Override
    public Country findById(Long id) {
        Query namedQuery = entityManager.createNamedQuery(Country.FIND_COUNTRY_BY_ID);
        namedQuery.setParameter("id", id);
        return (Country) namedQuery.getSingleResult();
    }

    @Override
    public List<Country> findAll() {
        Query nativeQuery = entityManager.createNativeQuery("SELECT c.id, c.name FROM Country c", Country.class);
        return nativeQuery.getResultList();
    }
}

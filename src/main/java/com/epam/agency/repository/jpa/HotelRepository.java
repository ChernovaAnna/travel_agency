package com.epam.agency.repository.jpa;

import com.epam.agency.domain.Hotel;
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
 * hotels' information.
 *
 * @author Hanna_Charnova
 * @version 1.0
 * Description of methods:
 * @see IRepository
 */
@Transactional
@Repository("hotelRepository")
public class HotelRepository implements IRepository<Hotel> {
    private final static Logger LOGGER = LoggerFactory.getLogger(HotelRepository.class);

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void create(Hotel entity) {
        entityManager.persist(entity);
    }

    @Override
    public void delete(Hotel entity) {
        Query namedQuery = entityManager.createNamedQuery(Hotel.DELETE_HOTEL);
        namedQuery.setParameter("id", entity.getId());
        namedQuery.executeUpdate();
    }

    @Override
    public void update(Hotel entity) {
        entityManager.merge(entity);
    }

    @Override
    public Hotel findById(Long id) {
        Query namedQuery = entityManager.createNamedQuery(Hotel.FIND_HOTEL_BY_ID);
        namedQuery.setParameter("id", id);
        return (Hotel) namedQuery.getSingleResult();
    }

    @Override
    public List<Hotel> findAll() {
        Query nativeQuery = entityManager.createNativeQuery("SELECT h.id, h.name, h.stars, h.website, h.lalitude, h.longitude, h.features FROM Hotel h", Hotel.class);
        return nativeQuery.getResultList();
    }
}

package com.epam.agency.repository.jpa;

import com.epam.agency.domain.Tour;
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
 * tours' information.
 *
 * @author Hanna_Charnova
 * @version 1.0
 * Description of methods:
 * @see IRepository
 */

@Transactional
@Repository("tourRepository")
public class TourRepository implements IRepository<Tour> {
    private final static Logger LOGGER = LoggerFactory.getLogger(TourRepository.class);

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void create(Tour entity) {
        entityManager.persist(entity);
    }

    @Override
    public void delete(Tour entity) {
        Query namedQuery = entityManager.createNamedQuery(Tour.DELETE_TOUR);
        namedQuery.setParameter("id", entity.getId());
        namedQuery.executeUpdate();
    }

    @Override
    public void update(Tour entity) {
        entityManager.merge(entity);
    }

    @Override
    public Tour findById(Long id) {
        Query namedQuery = entityManager.createNamedQuery(Tour.FIND_TOUR_BY_ID);
        namedQuery.setParameter("id", id);
        return (Tour) namedQuery.getSingleResult();
    }

    @Override
    public List<Tour> findAll() {
        Query nativeQuery = entityManager.createNativeQuery("SELECT t.id, t.photo, t.date, t.duration, t.description,t.cost,t.tour_type,t.hotel_id,t.country_id FROM Tour t", Tour.class);
        return nativeQuery.getResultList();
    }
}

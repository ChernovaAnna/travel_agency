package com.epam.agency.repository.jpa;

import com.epam.agency.domain.Review;
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
 * reviews' information.
 *
 * @author Hanna_Charnova
 * @version 1.0
 * Description of methods:
 * @see IRepository
 */

@Transactional
@Repository("reviewRepository")
public class ReviewRepository implements IRepository<Review> {
    private final static Logger LOGGER = LoggerFactory.getLogger(ReviewRepository.class);
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void create(Review entity) {
        entityManager.persist(entity);
    }

    @Override
    public void delete(Review entity) {
        Query namedQuery = entityManager.createNamedQuery(Review.DELETE_REVIEW);
        namedQuery.setParameter("id", entity.getId());
        namedQuery.executeUpdate();
    }

    @Override
    public void update(Review entity) {
        entityManager.merge(entity);
    }

    @Override
    public Review findById(Long id) {
        Query namedQuery = entityManager.createNamedQuery(Review.FIND_REVIEW_BY_ID);
        namedQuery.setParameter("id", id);

        return (Review) namedQuery.getSingleResult();
    }

    @Override
    public List<Review> findAll() {
        Query nativeQuery = entityManager.createNativeQuery("SELECT r.id, r.date, r.text, r.client_id, r.tour_id FROM Review r", Review.class);
        return nativeQuery.getResultList();
    }
}

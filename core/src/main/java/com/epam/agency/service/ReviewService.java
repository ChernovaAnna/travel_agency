package com.epam.agency.service;

import com.epam.agency.domain.Review;
import com.epam.agency.domain.Tour;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ReviewService {
    /**
     * Create Review in the repository.
     *
     * @param review
     */
    void create(Review review);

    /**
     * Update Review from the repository.
     *
     * @param review
     */
    void update(Review review);

    /**
     * Delete Review from the repository
     *
     * @param review
     */
    void delete(Review review);

    /**
     * @return all entities from concrete repository
     */
    List<Review> findAll();

    /**
     * Find Review by id in the repository
     *
     * @param id of Review
     * @return Review with corresponding id
     */
    Review findById(Long id);

    List<Review> findByTourId(Tour tour);
}

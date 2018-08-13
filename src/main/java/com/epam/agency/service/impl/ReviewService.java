package com.epam.agency.service.impl;

import com.epam.agency.domain.Review;
import com.epam.agency.repository.jpa.ReviewRepository;
import com.epam.agency.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implements IService interface and
 * realizes it's methods
 *
 * @author Hanna_Charnova
 * @version 1.0
 * Description of methods:
 * @see IService
 */

@Service("reviewService")
public class ReviewService implements IService<Review> {
    @Autowired
    private ReviewRepository reviewRepository;

    @Override
    public void create(Review review) {
        reviewRepository.create(review);
    }

    @Override
    public void update(Review review) {
        reviewRepository.update(review);
    }

    @Override
    public void delete(Review review) {
        reviewRepository.delete(review);
    }

    @Override
    public List<Review> findAll() {
        return reviewRepository.findAll();
    }

    @Override
    public Review findById(Long id) {
        return reviewRepository.findById(id);
    }
}

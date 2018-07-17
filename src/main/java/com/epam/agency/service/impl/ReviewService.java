package com.epam.agency.service.impl;

import com.epam.agency.domain.Review;
import com.epam.agency.repository.impl.ReviewRepository;
import com.epam.agency.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("reviewService")
public class ReviewService implements IService<Review> {
    @Autowired
    private ReviewRepository reviewRepository;

    @Override
    public void create(Review entity) {
        reviewRepository.create(entity);
    }

    @Override
    public void update(Review entity) {
        reviewRepository.update(entity);
    }

    @Override
    public void delete(Review entity) {
        reviewRepository.delete(entity);
    }

    @Override
    public List<Review> findAll() {
        return reviewRepository.findAll();
    }

    @Override
    public Review findById(int id) {
        return reviewRepository.findById(id);
    }
}

package com.epam.agency.service.impl;

import com.epam.agency.domain.Review;
import com.epam.agency.exception.BusinessException;
import com.epam.agency.exception.type.BusinessExceptionCode;
import com.epam.agency.repository.ReviewRepository;
import com.epam.agency.service.ReviewService;
import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
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
 * @see ReviewServiceImpl
 */
@Service("ReviewService")
@AllArgsConstructor
public class ReviewServiceImpl implements ReviewService {

    private ReviewRepository reviewRepository;

    @Override
    public void create(Review review) {
        reviewRepository.save(review);
    }

    @Override
    public void update(Review review) {
        reviewRepository.save(review);
    }

    @Override
    public void delete(Review review) {
        reviewRepository.delete(review);
    }

    @Override
    public List<Review> findAll() {
        List<Review> reviews = Lists.newArrayList(reviewRepository.findAll());
        if (reviews.isEmpty()) {
            throw new BusinessException(BusinessExceptionCode.NO_REVIEWS_FOUND);
        }
        return reviews;
    }

    @Override
    public Review findById(Long id) {
        return reviewRepository.findById(id).orElseThrow(() -> new BusinessException(BusinessExceptionCode.REVIEW_NOT_FOUND));
    }
}

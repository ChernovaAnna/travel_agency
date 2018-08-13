//package com.epam.agency.service;
//
//import com.epam.agency.domain.Client;
//import com.epam.agency.domain.Review;
//import com.epam.agency.domain.Tour;
//import com.epam.agency.repository.jpa.ReviewRepository;
//import com.epam.agency.service.jpa.ReviewService;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.mockito.runners.MockitoJUnitRunner;
//
//import java.time.LocalDate;
//import java.time.Month;
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.hamcrest.CoreMatchers.is;
//import static org.hamcrest.CoreMatchers.notNullValue;
//import static org.junit.Assert.assertThat;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//
//
//@RunWith(MockitoJUnitRunner.class)
//public class ReviewServiceTest {
//    @InjectMocks
//    private ReviewService reviewService;
//    @Mock
//    private ReviewRepository reviewRepository;
//    private Review review;
//
//    @Before
//    public void init() {
//        MockitoAnnotations.initMocks(this);
//        review = new Review();
//        review.setDate(LocalDate.of(2018, Month.APRIL, 30));
//        review.setText("Excellent.");
//        review.setClient(new Client());
//        review.setTour(new Tour());
//    }
//
//    @Test
//    public void testCreateReview() {
//        reviewService.create(review);
//        verify(reviewRepository).create(review);
//    }
//
//    @Test
//    public void testDeleteReview() {
//        reviewService.delete(review);
//        verify(reviewRepository).delete(review);
//    }
//
//    @Test
//    public void testUpdateReview() {
//        reviewService.update(review);
//        verify(reviewRepository).update(review);
//    }
//
//    @Test
//    public void testFindAllReviews() {
//        when(reviewRepository.findAll()).thenReturn(new ArrayList<>());
//        List<Review> reviews = reviewService.findAll();
//        verify(reviewRepository).findAll();
//        assertThat(reviews, is(notNullValue()));
//    }
//
//    @Test
//    public void testFindReviewById() {
//        when(reviewRepository.findById(0)).thenReturn(review);
//        Review review = reviewService.findById(0);
//        verify(reviewRepository).findById(0);
//        assertThat(review, is(notNullValue()));
//    }
//}

//package com.epam.agency.repository;
//
//import com.epam.agency.config.TestConfig;
//import com.epam.agency.domain.Review;
//import com.epam.agency.repository.jpa.ReviewRepository;
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.mockito.runners.MockitoJUnitRunner;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//import org.springframework.context.support.AbstractApplicationContext;
//
//import java.sql.Date;
//import java.util.List;
//
//import static org.hamcrest.CoreMatchers.is;
//import static org.hamcrest.CoreMatchers.notNullValue;
//import static org.junit.Assert.assertThat;
//import static org.mockito.Mockito.verify;
//
//@RunWith(MockitoJUnitRunner.class)
//public class ReviewRepositoryTest {
//    @Mock
//    private ReviewRepository reviewRepositoryMocked;
//
//    @Autowired
//    private ReviewRepository reviewRepository;
//    private AbstractApplicationContext context;
//
//    @Before
//    public void init() {
//        MockitoAnnotations.initMocks(this);
//        context = new AnnotationConfigApplicationContext();
//        context.getEnvironment().setActiveProfiles("development");
//        ((AnnotationConfigApplicationContext) context).register(TestConfig.class);
//        context.refresh();
//        reviewRepository = (ReviewRepository) context.getBean("reviewRepository");
//    }
//
//    @After
//    public void destroy() {
//        reviewRepository = null;
//        context.close();
//    }
//
//    @Test
//    public void testCreateReview() {
//        reviewRepository.create((Review) context.getBean("reviewForAdd"));
//        assertThat(reviewRepository.findById(4), is(notNullValue()));
//        assertThat(reviewRepository.findById(4).getText(), is("Excellent."));
//    }
//
//    @Test
//    public void testUpdateReview() {
//        Review review = (Review) (context.getBean("reviewForUpdate"));
//        review.setText("Excellent.");
//        reviewRepository.update(review);
//        assertThat(reviewRepository.findById(2), is(notNullValue()));
//        assertThat(reviewRepository.findById(2).getText(), is("Excellent."));
//    }
//
//    @Test
//    public void testDeleteReview() {
//        Review review = new Review();
//        reviewRepositoryMocked.delete(review);
//        verify(reviewRepositoryMocked).delete(review);
//    }
//
//    @Test
//    public void testFindAllReviews() {
//        List<Review> reviews = reviewRepository.findAll();
//        assertThat(reviews.size(),is(3));
//    }
//
//    @Test
//    public void testFindReviewById() {
//        Review review = reviewRepository.findById(2);
//        assertThat(review.getText(),is("In quis justo. Maecenas rhoncus aliquam lacus. Morbi quis tortor id nulla ultrices aliquet."));
//    }
//
//}

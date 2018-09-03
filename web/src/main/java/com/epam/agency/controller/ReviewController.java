package com.epam.agency.controller;

import com.epam.agency.service.ReviewService;
import com.epam.agency.service.TourService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletRequest;

@Controller
@AllArgsConstructor
public class ReviewController {
    private TourService tourService;
    private ReviewService reviewService;

//    @GetMapping(value = "/reviews")
//    public String findAllReviews(HttpServletRequest request) {
//        List<Review> reviews = reviewService.findAll();
//        request.getSession().setAttribute("reviewList", reviews);
//        return PageName.REVIEWS.getValue();
//    }

    @GetMapping(path = "/{id}")
    public String findReviewsByTourId(@PathVariable Long id, HttpServletRequest request) {
        reviewService.findByTourId(tourService.findById(id));
        return PageName.HOME.getValue();
    }

}
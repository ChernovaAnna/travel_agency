package com.epam.agency.controller;

import com.epam.agency.domain.Review;
import com.epam.agency.service.ReviewService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@AllArgsConstructor
public class ReviewController {

    private ReviewService reviewService;

    @GetMapping(value = "/reviews")
    public String findAllReviews(HttpServletRequest request) {
        List<Review> reviews = reviewService.findAll();
        request.getSession().setAttribute("reviewList", reviews);
        return PageName.REVIEWS.getValue();
    }
}
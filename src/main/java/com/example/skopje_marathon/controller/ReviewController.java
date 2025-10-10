package com.example.skopje_marathon.controller;

import com.example.skopje_marathon.dto.ReviewDTO;
import com.example.skopje_marathon.model.Review;
import com.example.skopje_marathon.service.ReviewService;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/reviews")
public class ReviewController {
    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @PostMapping("/{raceId}")
    public ReviewDTO addReview(@PathVariable Long raceId,
                               @RequestBody Review review,
                               Principal principal) {
        String email = principal.getName();
        return reviewService.addReview(raceId, review, email);
    }

    @GetMapping("/{raceId}")
    public List<ReviewDTO> getReviews(@PathVariable Long raceId) {
        return reviewService.getReviewsForRace(raceId);
    }
}


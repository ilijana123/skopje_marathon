package com.example.skopje_marathon.service;

import com.example.skopje_marathon.dto.ReviewDTO;
import com.example.skopje_marathon.mapper.ReviewMapper;
import com.example.skopje_marathon.model.Contestant;
import com.example.skopje_marathon.model.Race;
import com.example.skopje_marathon.model.Review;
import com.example.skopje_marathon.repository.ContestantRepository;
import com.example.skopje_marathon.repository.RaceRepository;
import com.example.skopje_marathon.repository.ReviewRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ReviewService {
    private final ReviewRepository reviewRepository;
    private final RaceRepository raceRepository;
    private final ContestantRepository contestantRepository;
    private final ReviewMapper reviewMapper;

    public ReviewService(ReviewRepository reviewRepository, RaceRepository raceRepository, ContestantRepository contestantRepository, ReviewMapper reviewMapper) {
        this.reviewRepository = reviewRepository;
        this.raceRepository = raceRepository;
        this.contestantRepository = contestantRepository;
        this.reviewMapper = reviewMapper;
    }

    public ReviewDTO addReview(Long raceId, Review review, String email) {
        Contestant contestant = contestantRepository.findByEmail(email);
        if (contestant == null) {
            throw new RuntimeException("Contestant not found for email: " + email);
        }

        Race race = raceRepository.findById(raceId)
                .orElseThrow(() -> new RuntimeException("Race not found with id: " + raceId));

        review.setContestant(contestant);
        review.setRace(race);
        Review saved = reviewRepository.save(review);
        return reviewMapper.toDto(saved);
    }

    public List<ReviewDTO> getReviewsForRace(Long raceId) {
        return reviewMapper.toDtoList(reviewRepository.findByRaceId(raceId));
    }
}


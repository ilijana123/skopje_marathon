package com.example.skopje_marathon.repository;

import com.example.skopje_marathon.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findByRaceId(Long raceId);
}


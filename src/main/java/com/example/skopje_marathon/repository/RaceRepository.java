package com.example.skopje_marathon.repository;

import com.example.skopje_marathon.enumeration.CategoryType;
import com.example.skopje_marathon.model.Race;
import com.example.skopje_marathon.enumeration.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RaceRepository extends JpaRepository<Race, Long> {
    Optional<Race> findByRegistrationNumber(String registrationNumber);
    Optional<Race> findTopByStatusOrderByStartNumberDesc(Status status);
    Optional<Race> findByContestantEmail(String email);
    List<Race> findByStatusAndContestantFirstNameContainingIgnoreCase(Status status, String firstName);
    List<Race> findByStatusAndCategory_Type(Status status, CategoryType type);
    List<Race> findByStatus(Status status);
}
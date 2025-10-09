package com.example.skopje_marathon.service;

import com.example.skopje_marathon.dto.CheckContestantRequest;
import com.example.skopje_marathon.dto.CheckContestantResponse;
import com.example.skopje_marathon.model.Race;
import com.example.skopje_marathon.enumeration.Status;
import com.example.skopje_marathon.repository.RaceRepository;
import org.springframework.stereotype.Service;

@Service
public class ContestantService {

    private final RaceRepository raceRepository;

    public ContestantService(RaceRepository raceRepository) {
        this.raceRepository = raceRepository;
    }

    public CheckContestantResponse checkContestant(CheckContestantRequest request) {
        Race race;

        if (request.email() != null && !request.email().isEmpty()) {
            race = raceRepository.findByContestantEmail(request.email())
                    .orElseThrow(() -> new RuntimeException("No contestant found with email: " + request.email()));
        } else if (request.registrationNumber() != null && !request.registrationNumber().isEmpty()) {
            race = raceRepository.findByRegistrationNumber(request.registrationNumber())
                    .orElseThrow(() -> new RuntimeException("No contestant found with registration number: " + request.registrationNumber()));
        } else {
            throw new RuntimeException("Either email or registration number is required.");
        }

        CheckContestantResponse response = new CheckContestantResponse();

        if (race.getStatus() == Status.PAID) {
            response.setMessage("Successful registration");
            response.setStartNumber(race.getStartNumber());
            response.setRegistrationNumber(race.getRegistrationNumber());
        } else {
            response.setMessage("It's not paid yet.");
            response.setRegistrationNumber(race.getRegistrationNumber());
            response.setPaymentLink("/payments/process/" + race.getId());
        }
        return response;
    }
}

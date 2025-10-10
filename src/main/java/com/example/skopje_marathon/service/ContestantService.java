package com.example.skopje_marathon.service;

import com.example.skopje_marathon.dto.CheckContestantRequest;
import com.example.skopje_marathon.dto.CheckContestantResponse;
import com.example.skopje_marathon.dto.ContestantDTO;
import com.example.skopje_marathon.enumeration.CategoryType;
import com.example.skopje_marathon.mapper.ContestantMapper;
import com.example.skopje_marathon.model.Race;
import com.example.skopje_marathon.enumeration.Status;
import com.example.skopje_marathon.repository.RaceRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContestantService {

    private final RaceRepository raceRepository;
    private final ContestantMapper contestantMapper;

    public ContestantService(RaceRepository raceRepository, ContestantMapper contestantMapper) {
        this.raceRepository = raceRepository;
        this.contestantMapper = contestantMapper;
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

        return getCheckContestantResponse(race);
    }

    @NotNull
    private static CheckContestantResponse getCheckContestantResponse(Race race) {
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

    public List<ContestantDTO> getAllPaidContestants() {
        return raceRepository.findByStatus(Status.PAID)
                .stream()
                .map(Race::getContestant)
                .map(contestantMapper::toDto)
                .toList();
    }

    public List<ContestantDTO> searchContestantsByName(String name) {
        return raceRepository.findByStatusAndContestantFirstNameContainingIgnoreCase(Status.PAID, name)
                .stream()
                .map(Race::getContestant)
                .map(contestantMapper::toDto)
                .toList();
    }

    public List<ContestantDTO> filterPaidByCategory(CategoryType categoryType) {
        return raceRepository.findByStatusAndCategory_Type(Status.PAID, categoryType)
                .stream()
                .map(Race::getContestant)
                .map(contestantMapper::toDto)
                .toList();
    }
}

package com.example.skopje_marathon.service;

import com.example.skopje_marathon.dto.RegisterRequest;
import com.example.skopje_marathon.dto.RegisterResponse;
import com.example.skopje_marathon.enumeration.Status;
import com.example.skopje_marathon.model.*;
import com.example.skopje_marathon.repository.CategoryRepository;
import com.example.skopje_marathon.repository.ContestantRepository;
import com.example.skopje_marathon.mapper.ContestantMapper;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.UUID;

@Service
public class RegistrationService {
    private final ContestantRepository contestantRepository;
    private final CategoryRepository categoryRepository;
    private final ContestantMapper contestantMapper;
    public RegistrationService(ContestantRepository contestantRepository, CategoryRepository categoryRepository, ContestantMapper contestantMapper){
        this.contestantRepository = contestantRepository;
        this.categoryRepository = categoryRepository;
        this.contestantMapper = contestantMapper;
    }

    @Transactional
    public RegisterResponse register(RegisterRequest registerRequest) {
        if(contestantRepository.findByEmail(registerRequest.email()) != null){
            throw new IllegalArgumentException("Email already in use");
        }
        Contestant contestant = contestantMapper.registerRequestToContestant(registerRequest);

        Category category = categoryRepository.findByType(registerRequest.categoryType())
                .orElseThrow(() -> new IllegalArgumentException("Invalid category type: " + registerRequest.categoryType()));

        Race race = new Race();
        race.setCategory(category);
        race.setStatus(Status.UNPAID);
        race.setRegistrationNumber(generateRegistratiomNumber());
        race.setContestant(contestant);

        contestant.setRace(race);
        contestantRepository.save(contestant);
        return new RegisterResponse(race.getRegistrationNumber(), "Registration successful");
    }

    private String generateRegistratiomNumber(){
        String generateUUIDNo = String.format("%010d",new BigInteger(UUID.randomUUID().toString().replace("-",""),16));
        return generateUUIDNo.substring( generateUUIDNo.length() - 10);
    }
}
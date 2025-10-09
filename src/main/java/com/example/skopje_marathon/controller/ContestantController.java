package com.example.skopje_marathon.controller;

import com.example.skopje_marathon.dto.CheckContestantRequest;
import com.example.skopje_marathon.dto.CheckContestantResponse;
import com.example.skopje_marathon.dto.RegisterRequest;
import com.example.skopje_marathon.dto.RegisterResponse;
import com.example.skopje_marathon.service.ContestantService;
import com.example.skopje_marathon.service.RegistrationService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/contestants")
public class ContestantController {
    private final RegistrationService registrationService;
    private final ContestantService contestantService;

    public ContestantController(RegistrationService registrationService, ContestantService contestantService) {
        this.registrationService = registrationService;
        this.contestantService = contestantService;
    }

    @PostMapping("/register")
    public RegisterResponse registerContestant(@Valid @RequestBody RegisterRequest registerRequest) {
        return registrationService.register(registerRequest);
    }

    @PostMapping("/check")
    public CheckContestantResponse checkContestant(@RequestBody CheckContestantRequest request) {
        return contestantService.checkContestant(request);
    }
}

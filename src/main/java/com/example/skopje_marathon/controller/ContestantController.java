package com.example.skopje_marathon.controller;

import com.example.skopje_marathon.model.RegisterRequest;
import com.example.skopje_marathon.model.RegisterResponse;
import com.example.skopje_marathon.service.RegistrationService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/contestants")
public class ContestantController {
    private final RegistrationService registrationService;
    public ContestantController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @PostMapping
    @RequestMapping("/register")
    public RegisterResponse registerContestant(@RequestBody RegisterRequest registerRequest) {
        return registrationService.register(registerRequest);
    }
}

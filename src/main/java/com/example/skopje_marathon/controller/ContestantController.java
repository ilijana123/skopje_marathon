package com.example.skopje_marathon.controller;

import com.example.skopje_marathon.dto.*;
import com.example.skopje_marathon.enumeration.CategoryType;
import com.example.skopje_marathon.service.ContestantService;
import com.example.skopje_marathon.service.RegistrationService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/contestants")
@CrossOrigin(origins = "http://localhost:5173", allowedHeaders = "*", allowCredentials = "true")
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

    @GetMapping
    public List<ContestantDTO> findAllPaid() {
        return contestantService.getAllPaidContestants();
    }

    @GetMapping("/search")
    public List<ContestantDTO> searchByName(@RequestParam String name) {
        return contestantService.searchContestantsByName(name);
    }

    @GetMapping("/filter")
    public List<ContestantDTO> filterByCategory(@RequestParam CategoryType category) {
        return contestantService.filterPaidByCategory(category);
    }
}
package com.example.skopje_marathon.controller;

import com.example.skopje_marathon.dto.RaceDTO;
import com.example.skopje_marathon.service.RaceService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/races")
public class RaceController {
    private final RaceService raceService;

    public RaceController(RaceService raceService) {
        this.raceService = raceService;
    }

    @GetMapping("/paid")
    public List<RaceDTO> getPaidRaces() {
        return raceService.getAllPaidRaces();
    }
}

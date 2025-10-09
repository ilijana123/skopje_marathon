package com.example.skopje_marathon.service;

import com.example.skopje_marathon.dto.RaceDTO;
import com.example.skopje_marathon.enumeration.Status;
import com.example.skopje_marathon.mapper.RaceMapper;
import com.example.skopje_marathon.repository.RaceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RaceService {
    private final RaceRepository raceRepository;
    private final RaceMapper raceMapper;

    public RaceService(RaceRepository raceRepository, RaceMapper raceMapper) {
        this.raceRepository = raceRepository;
        this.raceMapper = raceMapper;
    }

    public List<RaceDTO> getAllPaidRaces() {
        return raceMapper.toDtoList(raceRepository.findByStatus(Status.PAID));
    }
}

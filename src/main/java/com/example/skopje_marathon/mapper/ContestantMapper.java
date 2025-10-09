package com.example.skopje_marathon.mapper;

import com.example.skopje_marathon.dto.ContestantDTO;
import com.example.skopje_marathon.model.Contestant;
import com.example.skopje_marathon.dto.RegisterRequest;
import org.mapstruct.Mapper;

@Mapper(
    componentModel = "spring"
)
public interface ContestantMapper{
    Contestant registerRequestToContestant(RegisterRequest registerRequest);
    ContestantDTO toDto(Contestant contestant);
}

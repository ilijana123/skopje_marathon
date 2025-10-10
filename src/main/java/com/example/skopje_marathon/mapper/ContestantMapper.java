package com.example.skopje_marathon.mapper;

import com.example.skopje_marathon.dto.ContestantDTO;
import com.example.skopje_marathon.model.Contestant;
import com.example.skopje_marathon.dto.RegisterRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(
    componentModel = "spring"
)
public interface ContestantMapper{
    Contestant registerRequestToContestant(RegisterRequest registerRequest);
    @Mapping(source = "race.startNumber", target = "startNumber")
    @Mapping(source = "race.category.distance", target = "distance")
    ContestantDTO toDto(Contestant contestant);
}

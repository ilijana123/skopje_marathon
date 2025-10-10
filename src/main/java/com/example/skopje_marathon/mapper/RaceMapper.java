package com.example.skopje_marathon.mapper;

import com.example.skopje_marathon.dto.RaceDTO;
import com.example.skopje_marathon.model.Race;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RaceMapper {
    @Mapping(source = "race.startNumber", target = "startNumber")
    @Mapping(source = "race.category.type", target = "categoryType")
    @Mapping(expression = "java(race.getContestant().getFirstName() + \" \" + race.getContestant().getLastName())",
            target = "contestantName")
    RaceDTO toDto(Race race);

    List<RaceDTO> toDtoList(List<Race> races);
}


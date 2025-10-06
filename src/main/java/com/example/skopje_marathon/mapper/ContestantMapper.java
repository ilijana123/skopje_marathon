package com.example.skopje_marathon.mapper;

import com.example.skopje_marathon.model.Contestant;
import com.example.skopje_marathon.model.RegisterRequest;
import org.mapstruct.Mapper;

@Mapper(
    componentModel = "spring"
)
public interface ContestantMapper{
    RegisterRequest contestantToRegisterRequest(Contestant contestant);
    Contestant registerRequestToContestant(RegisterRequest registerRequest);
}

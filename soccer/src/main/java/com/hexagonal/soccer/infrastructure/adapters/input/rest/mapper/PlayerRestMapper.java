package com.hexagonal.soccer.infrastructure.adapters.input.rest.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.hexagonal.soccer.domain.model.Player;
import com.hexagonal.soccer.infrastructure.adapters.input.rest.dto.request.PlayerDtoRequest;
import com.hexagonal.soccer.infrastructure.adapters.input.rest.dto.response.PlayerDtoResponse;


@Mapper(componentModel = "spring")
public interface PlayerRestMapper {

    @Mapping(target = "energy", ignore = true)
    @Mapping(target = "id", ignore = true)
    Player toDomain(PlayerDtoRequest playerDtoRequest);

    PlayerDtoRequest toDtoRequest(Player player);

    PlayerDtoResponse toDtoResponse(Player player);
}

package com.hexagonal.player.infrastructure.adapters.input.rest.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.hexagonal.player.domain.model.Player;
import com.hexagonal.player.infrastructure.adapters.input.rest.dto.request.PlayerDtoRequest;
import com.hexagonal.player.infrastructure.adapters.input.rest.dto.response.PlayerDtoResponse;


@Mapper(componentModel = "spring")
public interface PlayerRestMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "energy", ignore = true)
    Player toDomain(PlayerDtoRequest playerDtoRequest);

    PlayerDtoRequest toDtoRequest(Player player);

    PlayerDtoResponse toDtoResponse(Player player);
}

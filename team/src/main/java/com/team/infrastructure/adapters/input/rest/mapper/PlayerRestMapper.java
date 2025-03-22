package com.team.infrastructure.adapters.input.rest.mapper;

import org.mapstruct.Mapper;

import com.team.domain.model.Player;
import com.team.infrastructure.adapters.input.rest.dto.response.PlayerDtoResponse;


@Mapper(componentModel = "spring")
public interface PlayerRestMapper {

    PlayerDtoResponse toDtoResponse(Player player);
}

package com.hexagonal.soccer.infrastructure.adapters.input.rest.mapper;

import org.mapstruct.Mapper;

import com.hexagonal.soccer.domain.model.Game;
import com.hexagonal.soccer.infrastructure.adapters.input.rest.dto.response.GameDtoResponse;

@Mapper(componentModel = "spring")
public interface GameRestMapper {
    GameDtoResponse toResponse(Game game);
}

package com.hexagonal.soccer.infrastructure.adapters.output.messageBroker.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.hexagonal.soccer.domain.model.Player;
import com.hexagonal.soccer.infrastructure.adapters.output.messageBroker.dto.PlayerDto;

@Mapper(componentModel = "spring")
public interface PlayerEventMapper {

    @Mapping(target = "team", ignore = true)
    Player toDomain(PlayerDto playerDto);
}

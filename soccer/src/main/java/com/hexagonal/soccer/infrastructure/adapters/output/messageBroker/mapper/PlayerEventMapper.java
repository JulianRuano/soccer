package com.hexagonal.soccer.infrastructure.adapters.output.messageBroker.mapper;

import org.mapstruct.Mapper;

import com.hexagonal.soccer.domain.model.Player;
import com.hexagonal.soccer.infrastructure.adapters.output.messageBroker.dto.PlayerDto;

@Mapper(componentModel = "spring")
public interface PlayerEventMapper {

    Player toDomain(PlayerDto playerDto);
}

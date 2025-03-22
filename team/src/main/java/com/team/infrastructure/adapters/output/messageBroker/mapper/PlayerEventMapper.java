package com.team.infrastructure.adapters.output.messageBroker.mapper;

import org.mapstruct.Mapper;

import com.team.domain.model.Player;
import com.team.infrastructure.adapters.output.messageBroker.dto.PlayerDto;

@Mapper(componentModel = "spring")
public interface PlayerEventMapper {

    Player toDomain(PlayerDto playerDto);
}

package com.team.infrastructure.adapters.output.messageBroker.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.team.domain.model.Player;
import com.team.infrastructure.adapters.output.messageBroker.dto.PlayerDto;

@Mapper(componentModel = "spring")
public interface PlayerEventMapper {

    @Mapping(target = "team", ignore = true)
    Player toDomain(PlayerDto playerDto);
}

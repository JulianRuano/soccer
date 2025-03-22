package com.hexagonal.player.infrastructure.adapters.output.messageBroker.mapper;

import org.mapstruct.Mapper;

import com.hexagonal.player.domain.model.Player;

import com.hexagonal.player.infrastructure.adapters.output.messageBroker.dto.PlayerDto;

@Mapper(componentModel = "spring")
public interface PlayerEventMapper {
   
    PlayerDto toDto(Player player );
}

package com.hexagonal.player.infrastructure.adapters.output.jpa.mapper;

import org.mapstruct.Mapper;

import com.hexagonal.player.domain.model.Player;
import com.hexagonal.player.infrastructure.adapters.output.jpa.entity.PlayerEntity;

@Mapper(componentModel = "spring")
public interface PlayerEntityMapper {

    PlayerEntity toEntity(Player player);
    
    Player toDomain(PlayerEntity playerEntity);
}

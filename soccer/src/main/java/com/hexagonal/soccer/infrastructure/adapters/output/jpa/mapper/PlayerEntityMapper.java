package com.hexagonal.soccer.infrastructure.adapters.output.jpa.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.hexagonal.soccer.domain.model.Player;
import com.hexagonal.soccer.infrastructure.adapters.output.jpa.entity.PlayerEntity;

@Mapper(componentModel = "spring")
public interface PlayerEntityMapper {

    @Mapping(target = "team", ignore = true)
    PlayerEntity toEntity(Player player);
    
    Player toDomain(PlayerEntity playerEntity);
}

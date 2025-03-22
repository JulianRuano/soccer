package com.team.infrastructure.adapters.output.jpa.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.team.domain.model.Player;
import com.team.infrastructure.adapters.output.jpa.entity.PlayerEntity;

@Mapper(componentModel = "spring")
public interface PlayerEntityMapper {

    @Mapping(target = "team", ignore = true)
    PlayerEntity toEntity(Player player);
    
    Player toDomain(PlayerEntity playerEntity);
}

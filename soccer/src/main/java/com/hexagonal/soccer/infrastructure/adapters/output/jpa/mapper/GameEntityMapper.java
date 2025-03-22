package com.hexagonal.soccer.infrastructure.adapters.output.jpa.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.hexagonal.soccer.domain.model.Game;
import com.hexagonal.soccer.infrastructure.adapters.output.jpa.entity.GameEntity;

@Mapper(componentModel = "spring", uses = {TeamEntityMapper.class})
public interface GameEntityMapper {

    Game toDomain(GameEntity gameEntity);

    @Mapping(target = "id", ignore = true)
    GameEntity toEntity(Game game);
}

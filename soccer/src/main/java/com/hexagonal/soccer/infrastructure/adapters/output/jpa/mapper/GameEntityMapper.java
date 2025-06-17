package com.hexagonal.soccer.infrastructure.adapters.output.jpa.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.hexagonal.soccer.domain.model.Game;
import com.hexagonal.soccer.infrastructure.adapters.output.jpa.entity.GameEntity;

@Mapper(componentModel = "spring", uses = {TeamEntityMapper.class})
public interface GameEntityMapper {

    Game toDomain(GameEntity gameEntity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "tenantId", ignore = true)
    GameEntity toEntity(Game game);

    List<Game> toDomainList(List<GameEntity> all);
}

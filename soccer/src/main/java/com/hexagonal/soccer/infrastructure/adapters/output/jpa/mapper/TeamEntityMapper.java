package com.hexagonal.soccer.infrastructure.adapters.output.jpa.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.hexagonal.soccer.domain.model.Team;
import com.hexagonal.soccer.infrastructure.adapters.output.jpa.entity.TeamEntity;

@Mapper(componentModel = "spring", uses = PlayerEntityMapper.class)
public interface TeamEntityMapper {
    
    @Mapping(target = "localGames", ignore = true)
    @Mapping(target = "visitorGames", ignore = true)
    @Mapping(target = "tenantId", ignore = true)
    TeamEntity toEntity(Team team);
    
    Team toDomain(TeamEntity teamEntity);
}

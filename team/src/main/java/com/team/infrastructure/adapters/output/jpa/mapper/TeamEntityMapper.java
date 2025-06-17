package com.team.infrastructure.adapters.output.jpa.mapper;

import org.mapstruct.Mapper;

import com.team.domain.model.Team;
import com.team.infrastructure.adapters.output.jpa.entity.TeamEntity;

@Mapper(componentModel = "spring", uses = PlayerEntityMapper.class)
public interface TeamEntityMapper {

    TeamEntity toEntity(Team team);
    
    Team toDomain(TeamEntity teamEntity);
}

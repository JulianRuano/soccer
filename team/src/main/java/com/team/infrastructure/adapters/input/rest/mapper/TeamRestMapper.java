package com.team.infrastructure.adapters.input.rest.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.team.domain.model.Team;
import com.team.infrastructure.adapters.input.rest.dto.request.TeamDtoRequest;
import com.team.infrastructure.adapters.input.rest.dto.response.TeamDtoResponse;

@Mapper(componentModel = "spring")
public interface TeamRestMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "players", ignore = true)
    Team toDomain(TeamDtoRequest teamDtoRequest);

    @Mapping(target = "idPlayers", ignore = true)
    TeamDtoRequest toDtoRequest(Team team);

    TeamDtoResponse toDtoResponse(Team team);
}

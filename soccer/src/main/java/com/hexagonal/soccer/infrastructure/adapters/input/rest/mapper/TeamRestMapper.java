package com.hexagonal.soccer.infrastructure.adapters.input.rest.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.hexagonal.soccer.domain.model.Team;
import com.hexagonal.soccer.infrastructure.adapters.input.rest.dto.request.TeamDtoRequest;
import com.hexagonal.soccer.infrastructure.adapters.input.rest.dto.response.TeamDtoResponse;

@Mapper(componentModel = "spring")
public interface TeamRestMapper {

    @Mapping(target = "alignment", ignore = true)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "players", ignore = true)
    Team toDomain(TeamDtoRequest teamDtoRequest);

    @Mapping(target = "alignment", ignore = true)
    @Mapping(target = "idPlayers", ignore = true)
    TeamDtoRequest toDtoRequest(Team team);

    @Mapping(target = "alignment", ignore = true)
    TeamDtoResponse toDtoResponse(Team team);
}

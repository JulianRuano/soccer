package com.team.infrastructure.adapters.input.rest.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.team.domain.model.Team;
import com.team.infrastructure.adapters.input.rest.dto.request.TeamDtoRequest;
import com.team.infrastructure.adapters.input.rest.dto.response.TeamDtoResponse;

@Mapper(componentModel = "spring")
public interface TeamRestMapper {

    @Mapping(target = "alignment", ignore = true)
    Team toDomain(TeamDtoRequest teamDtoRequest);

    @Mapping(target = "alignment", ignore = true)
    TeamDtoRequest toDtoRequest(Team team);

    @Mapping(target = "alignment", ignore = true)
    TeamDtoResponse toDtoResponse(Team team);
}

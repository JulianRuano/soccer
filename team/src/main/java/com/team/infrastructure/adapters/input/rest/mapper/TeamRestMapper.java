package com.team.infrastructure.adapters.input.rest.mapper;

import java.util.ArrayList;
import java.util.stream.Collectors;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.team.domain.model.Player;
import com.team.domain.model.Team;
import com.team.infrastructure.adapters.input.rest.dto.request.TeamDtoRequest;
import com.team.infrastructure.adapters.input.rest.dto.response.TeamDtoResponse;

@Mapper(componentModel = "spring")
public interface TeamRestMapper {


    default Team toDomain(TeamDtoRequest teamDtoRequest) {
        return Team.builder()
                .name(teamDtoRequest.getName())
                .players(
                    teamDtoRequest.getIdPlayers() != null ? 
                    teamDtoRequest.getIdPlayers().stream()
                    .map(Player::new)
                    .collect(Collectors.toList()) : new ArrayList<>())
                .build();         
    }

    @Mapping(target = "idPlayers", ignore = true)
    TeamDtoRequest toDtoRequest(Team team);

    TeamDtoResponse toDtoResponse(Team team);
}

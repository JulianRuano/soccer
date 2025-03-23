package com.team.infrastructure.adapters.input.rest.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.team.application.ports.input.ITeamInputPort;
import com.team.application.ports.input.ITeamManagerInputPort;
import com.team.domain.model.Player;
import com.team.domain.model.Team;
import com.team.infrastructure.adapters.input.rest.dto.ResponseDto;
import com.team.infrastructure.adapters.input.rest.dto.request.TeamDtoRequest;
import com.team.infrastructure.adapters.input.rest.dto.response.PlayerDtoResponse;
import com.team.infrastructure.adapters.input.rest.dto.response.TeamDtoResponse;
import com.team.infrastructure.adapters.input.rest.mapper.PlayerRestMapper;
import com.team.infrastructure.adapters.input.rest.mapper.TeamRestMapper;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/team")
public class TeamRestController {
    
    private final ITeamInputPort teamInputPort;
    private final ITeamManagerInputPort teamManagerInputPort;

    private final TeamRestMapper teamRestMapper;
    private final PlayerRestMapper playerRestMapper;

    @PostMapping("/create")
    public ResponseEntity<ResponseDto<TeamDtoResponse>> createTeam(@RequestBody TeamDtoRequest teamDtoRequest) {
        Team team = teamRestMapper.toDomain(teamDtoRequest);
        team = teamInputPort.createTeam(team, teamDtoRequest.getIdPlayers());

        TeamDtoResponse teamDtoResponse = teamRestMapper.toDtoResponse(team);
        return ResponseDto.<TeamDtoResponse>builder()
            .data(teamDtoResponse)
            .message("Team created successfully")
            .status(201)
            .build()
            .of();
    }

    @PutMapping("/player")
    public ResponseEntity<ResponseDto<PlayerDtoResponse>> addPlayerToTeam(@RequestParam Long teamId, @RequestParam Long playerId) {
        Player player = teamManagerInputPort.addPlayerToTeam(teamId, playerId);
        PlayerDtoResponse playerDtoResponses = playerRestMapper.toDtoResponse(player);

        return ResponseDto.<PlayerDtoResponse>builder()
            .data(playerDtoResponses)
            .message("Players added to team successfully")
            .status(200)
            .build()
            .of();
    }

}

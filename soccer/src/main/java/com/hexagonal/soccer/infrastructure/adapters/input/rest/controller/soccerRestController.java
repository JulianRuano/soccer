package com.hexagonal.soccer.infrastructure.adapters.input.rest.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexagonal.soccer.application.ports.input.IPlayGameInputPort;
import com.hexagonal.soccer.application.ports.input.IPlayerInputPort;
import com.hexagonal.soccer.application.ports.input.ITeamInputPort;
import com.hexagonal.soccer.application.ports.input.ITeamManagerInputPort;
import com.hexagonal.soccer.domain.model.Game;
import com.hexagonal.soccer.domain.model.Player;
import com.hexagonal.soccer.domain.model.Team;
import com.hexagonal.soccer.infrastructure.adapters.input.rest.dto.ResponseDto;
import com.hexagonal.soccer.infrastructure.adapters.input.rest.dto.request.PlayerDtoRequest;
import com.hexagonal.soccer.infrastructure.adapters.input.rest.dto.request.TeamDtoRequest;
import com.hexagonal.soccer.infrastructure.adapters.input.rest.dto.response.GameDtoResponse;
import com.hexagonal.soccer.infrastructure.adapters.input.rest.dto.response.PlayerDtoResponse;
import com.hexagonal.soccer.infrastructure.adapters.input.rest.dto.response.TeamDtoResponse;
import com.hexagonal.soccer.infrastructure.adapters.input.rest.mapper.GameRestMapper;
import com.hexagonal.soccer.infrastructure.adapters.input.rest.mapper.PlayerRestMapper;
import com.hexagonal.soccer.infrastructure.adapters.input.rest.mapper.TeamRestMapper;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/soccer")
public class soccerRestController {
    
    private final IPlayGameInputPort playGameInputPort;
    private final IPlayerInputPort playerInputPort;
    private final ITeamInputPort teamInputPort;
    private final ITeamManagerInputPort teamManagerInputPort;

    private final GameRestMapper gameRestMapper;
    private final TeamRestMapper teamRestMapper;
    private final PlayerRestMapper playerRestMapper;

    @PostMapping("/player")
    public ResponseEntity<ResponseDto<PlayerDtoResponse>> createPlayer(@RequestBody PlayerDtoRequest playerDtoRequest) {
        Player player = playerRestMapper.toDomain(playerDtoRequest);
        player = playerInputPort.createPlayer(player);

        PlayerDtoResponse playerDtoResponse = playerRestMapper.toDtoResponse(player);
        return ResponseDto.<PlayerDtoResponse>builder()
            .data(playerDtoResponse)
            .message("Player created successfully")
            .status(201)
            .build()
            .of();   
    }

    @PostMapping("/team")
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

    @PostMapping("/play/{localTeamId}/{visitorTeamId}")
    public ResponseEntity<ResponseDto<GameDtoResponse>> playGame(@PathVariable Long localTeamId, @PathVariable Long visitorTeamId) {
        Game game = playGameInputPort.playGame(localTeamId, visitorTeamId);
        GameDtoResponse GameDtoResponse = gameRestMapper.toResponse(game);

        return ResponseDto.<GameDtoResponse>builder()
            .data(GameDtoResponse)
            .message("Game played successfully")
            .status(201)
            .build()
            .of();
    }

    @PutMapping("/player/team/{teamId}")
    public ResponseEntity<ResponseDto<PlayerDtoResponse>> addPlayerToTeam(@PathVariable Long teamId, @RequestBody Long playerId) {
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

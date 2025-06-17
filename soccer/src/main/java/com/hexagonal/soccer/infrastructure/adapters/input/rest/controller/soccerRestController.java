package com.hexagonal.soccer.infrastructure.adapters.input.rest.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexagonal.soccer.application.ports.input.IPlayGameInputPort;
import com.hexagonal.soccer.domain.model.Game;
import com.hexagonal.soccer.infrastructure.adapters.input.rest.dto.ResponseDto;
import com.hexagonal.soccer.infrastructure.adapters.input.rest.dto.response.GameDtoResponse;
import com.hexagonal.soccer.infrastructure.adapters.input.rest.mapper.GameRestMapper;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/soccer")
public class soccerRestController {
    
    private final IPlayGameInputPort playGameInputPort;

    private final GameRestMapper gameRestMapper;

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

    @GetMapping("/games")
    public ResponseEntity<ResponseDto<List<GameDtoResponse>>> getAllGames() {
        List<Game> games = playGameInputPort.getAllGames();
        List<GameDtoResponse> gameDtoResponses = gameRestMapper.toResponseList(games);

        return ResponseDto.<List<GameDtoResponse>>builder()
            .data(gameDtoResponses)
            .message("Games retrieved successfully")
            .status(200)
            .build()
            .of();
    }

}

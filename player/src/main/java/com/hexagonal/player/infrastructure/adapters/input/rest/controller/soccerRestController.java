package com.hexagonal.player.infrastructure.adapters.input.rest.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexagonal.player.application.port.IPlayerInputPort;
import com.hexagonal.player.domain.model.Player;
import com.hexagonal.player.infrastructure.adapters.input.rest.dto.ResponseDto;
import com.hexagonal.player.infrastructure.adapters.input.rest.dto.request.PlayerDtoRequest;
import com.hexagonal.player.infrastructure.adapters.input.rest.dto.response.PlayerDtoResponse;
import com.hexagonal.player.infrastructure.adapters.input.rest.mapper.PlayerRestMapper;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/player")
public class soccerRestController {
    
    private final IPlayerInputPort playerInputPort;
    private final PlayerRestMapper playerRestMapper;

    @PostMapping("/create")
    public ResponseEntity<ResponseDto<PlayerDtoResponse>> createPlayer(@RequestBody PlayerDtoRequest playerDtoRequest) {
        Player player = playerRestMapper.toDomain(playerDtoRequest);
        player = playerInputPort.createPlayer(player);

        PlayerDtoResponse playerDtoResponse = playerRestMapper.toDtoResponse(player);
        ResponseDto<PlayerDtoResponse> response = ResponseDto.<PlayerDtoResponse>builder()
        .data(playerDtoResponse)
        .message("Player created successfully")
        .status(201)
        .build();

        return response.of();
    }

}

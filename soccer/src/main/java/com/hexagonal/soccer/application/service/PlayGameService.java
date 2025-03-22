package com.hexagonal.soccer.application.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.hexagonal.soccer.application.ports.input.IPlayGameInputPort;
import com.hexagonal.soccer.application.ports.output.IGameOutputPort;
import com.hexagonal.soccer.application.ports.output.ITeamOutputPort;
import com.hexagonal.soccer.domain.domainServices.GameSimulator;
import com.hexagonal.soccer.domain.model.Game;
import com.hexagonal.soccer.domain.model.Team;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PlayGameService implements IPlayGameInputPort {

    private final GameSimulator gameSimulator;
    private final ITeamOutputPort teamOutputPort;
    private final IGameOutputPort gameOutputPort;

    @Override
    public Game playGame(Long localTeamId, Long visitorTeamId) {
        Optional<Team> localTeam = teamOutputPort.getTeamById(localTeamId);
        Optional<Team> visitorTeam = teamOutputPort.getTeamById(visitorTeamId);

        if (localTeam.isPresent() && visitorTeam.isPresent()) {
            Game game = gameSimulator.simulateGame(localTeam.get(), visitorTeam.get());
            gameOutputPort.createGame(game);
            return game;
        }

        return null;   
    }

}

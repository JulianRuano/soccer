package com.hexagonal.soccer.application.ports.input;

import java.util.List;

import com.hexagonal.soccer.domain.model.Game;

public interface IPlayGameInputPort {
    Game playGame(Long localTeamId, Long visitorTeamId);
    List<Game> getAllGames();
}

package com.hexagonal.soccer.domain.port;

import java.util.List;

import com.hexagonal.soccer.domain.model.Game;

public interface IGameRepositoryPort {
    Game createGame(Game game);
    List<Game> getAllGames();
}

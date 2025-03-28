package com.hexagonal.soccer.domain.port;

import com.hexagonal.soccer.domain.model.Game;

public interface IGameRepositoryPort {
    Game createGame(Game game);
}

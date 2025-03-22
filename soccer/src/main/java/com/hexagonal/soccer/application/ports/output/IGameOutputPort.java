package com.hexagonal.soccer.application.ports.output;

import com.hexagonal.soccer.domain.model.Game;

public interface IGameOutputPort {
    Game createGame(Game game);
}

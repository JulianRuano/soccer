package com.hexagonal.soccer.application.ports.input;

import com.hexagonal.soccer.domain.model.Game;

public interface IPlayGameInputPort {
    Game playGame(Long localTeamId, Long visitorTeamId);
}

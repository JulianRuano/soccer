package com.hexagonal.soccer.application.ports.input;

import java.util.Optional;

import com.hexagonal.soccer.domain.model.Player;

public interface IPlayerInputPort {
    Player createPlayer(Player player);
    Player updatePlayer(Long id, Player player);
    Optional<Player> getPlayerById(Long id);
}

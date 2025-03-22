package com.hexagonal.soccer.application.ports.output;

import java.util.Optional;

import com.hexagonal.soccer.domain.model.Player;


public interface IPlayerOutputPort {
    Player createPlayer(Player player);
    Player updatePlayer(Long id, Player player);
    Optional<Player> getPlayerById(Long id);
}

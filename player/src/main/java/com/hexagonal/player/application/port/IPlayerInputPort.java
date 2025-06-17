package com.hexagonal.player.application.port;

import java.util.Optional;

import com.hexagonal.player.domain.model.Player;

public interface IPlayerInputPort {
    Player createPlayer(Player player);
    Player updatePlayer(Long id, Player player);
    Optional<Player> getPlayerById(Long id);
}

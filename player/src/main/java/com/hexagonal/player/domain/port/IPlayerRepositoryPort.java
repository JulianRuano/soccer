package com.hexagonal.player.domain.port;

import java.util.Optional;

import com.hexagonal.player.domain.model.Player;


public interface IPlayerRepositoryPort {
    Player createPlayer(Player player);
    Player updatePlayer(Long id, Player player);
    Optional<Player> getPlayerById(Long id);
}

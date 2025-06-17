package com.hexagonal.soccer.domain.port;

import java.util.Optional;

import com.hexagonal.soccer.domain.model.Player;


public interface IPlayerRepositoryPort {
    Player createPlayer(Player player);
    Player updatePlayer(Long id, Player player);
    Optional<Player> getPlayerById(Long id);
}

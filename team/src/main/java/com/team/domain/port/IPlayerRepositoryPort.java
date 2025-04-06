package com.team.domain.port;

import java.util.Optional;

import com.team.domain.model.Player;


public interface IPlayerRepositoryPort {
    Player createPlayer(Player player);
    Player updatePlayer(Long id, Player player);
    Optional<Player> getPlayerById(Long id);
}

package com.team.application.port;

import java.util.Optional;

import com.team.domain.model.Player;

public interface IPlayerInputPort {
    Player createPlayer(Player player);
    Player updatePlayer(Long id, Player player);
    Optional<Player> getPlayerById(Long id);
}

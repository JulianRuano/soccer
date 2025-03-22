package com.team.application.ports.output;

import java.util.Optional;

import com.team.domain.model.Player;


public interface IPlayerOutputPort {
    Player createPlayer(Player player);
    Player updatePlayer(Long id, Player player);
    Optional<Player> getPlayerById(Long id);
}

package com.hexagonal.soccer.application.ports.output;

import com.hexagonal.soccer.domain.model.Player;

public interface ITeamManagerOutputPort {
    Player addPlayerToTeam(Player player, Long teamId);
    Player removePlayerFromTeam(Player player, Long teamId);
}

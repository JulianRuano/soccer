package com.hexagonal.soccer.domain.port;

import com.hexagonal.soccer.domain.model.Player;

public interface ITeamManagerPort {
    Player addPlayerToTeam(Player player, Long teamId);
    Player removePlayerFromTeam(Player player, Long teamId);
}

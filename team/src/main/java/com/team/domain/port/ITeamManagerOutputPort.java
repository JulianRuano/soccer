package com.team.domain.port;

import com.team.domain.model.Player;

public interface ITeamManagerOutputPort {
    Player addPlayerToTeam(Player player, Long teamId);
    Player removePlayerFromTeam(Player player, Long teamId);
}

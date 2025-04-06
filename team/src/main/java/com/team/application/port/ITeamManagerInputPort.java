package com.team.application.port;

import com.team.domain.model.Player;

public interface ITeamManagerInputPort {
    Player addPlayerToTeam(Long teamId, Long playerId);
    boolean removePlayerFromTeam(Long teamId, Long playerId);
}

package com.hexagonal.soccer.application.ports.input;

import com.hexagonal.soccer.domain.model.Player;

public interface ITeamManagerInputPort {
    Player addPlayerToTeam(Long teamId, Long playerId);
    boolean removePlayerFromTeam(Long teamId, Long playerId);
}

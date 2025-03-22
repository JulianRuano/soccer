package com.hexagonal.soccer.application.ports.input;

import java.util.List;
import java.util.Optional;
import com.hexagonal.soccer.domain.model.Team;

public interface ITeamInputPort {
    Team createTeam(Team team, List<Long> idPlayers);
    Team updateTeam(Long id, Team team);
    Optional<Team> getTeamById(Long id);
}

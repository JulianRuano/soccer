package com.team.application.ports.output;

import java.util.Optional;

import com.team.domain.model.Team;

public interface ITeamOutputPort {
    Team createTeam(Team team);
    Team updateTeam(Long id, Team team);
    Optional<Team> getTeamById(Long id);
}

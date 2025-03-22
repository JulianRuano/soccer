package com.hexagonal.soccer.application.ports.output;

import java.util.Optional;
import com.hexagonal.soccer.domain.model.Team;

public interface ITeamOutputPort {
    Team createTeam(Team team);
    Team updateTeam(Long id, Team team);
    Optional<Team> getTeamById(Long id);
}

package com.hexagonal.soccer.domain.port;

import java.util.Optional;
import com.hexagonal.soccer.domain.model.Team;

public interface ITeamRepositoryPort {
    Team createTeam(Team team);
    Team updateTeam(Long id, Team team);
    Optional<Team> getTeamById(Long id);
}

package com.team.application.ports.output;

import java.util.List;
import java.util.Optional;

import com.team.domain.model.Team;

public interface ITeamOutputPort {
    Team createTeam(Team team,List<Long> idPlayers);
    Team updateTeam(Long id, Team team);
    Optional<Team> getTeamById(Long id);
    boolean existsById(Long id);
    List<Long> findExistingPlayerIds(List<Long> idPlayers);
}

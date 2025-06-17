package com.team.application.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.team.application.port.ITeamInputPort;
import com.team.domain.model.Player;
import com.team.domain.model.Team;
import com.team.domain.port.IFormatterResultOutputPort;
import com.team.domain.port.ITeamRepositoryPort;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TeamService implements ITeamInputPort {
    
    private final ITeamRepositoryPort teamOutputPort;
    private final IFormatterResultOutputPort formatterResultOutputPort;


    @Override
    public Team createTeam(Team team, List<Long> idPlayers) {

        if (!teamOutputPort.existsById(team.getId())) {
            formatterResultOutputPort.returnResponseError(404, "Team not found");
        }

        List<Long> findExistingPlayerIds = teamOutputPort.findExistingPlayerIds(idPlayers);

        if (idPlayers.size() != findExistingPlayerIds.size()) {
            List<Long> missingPlayerIds = getMissingPlayerIds(idPlayers);
            formatterResultOutputPort.returnResponseError(404, "Player not found: "+missingPlayerIds);
        }

        for (Long idPlayer : idPlayers) {
            team.addPlayer(new Player(idPlayer));
        }
        
        return teamOutputPort.createTeam(team, idPlayers);
    }

    @Override
    public Team updateTeam(Long id, Team team) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateTeam'");
    }

    @Override
    public Optional<Team> getTeamById(Long id) {
        Optional<Team> team = teamOutputPort.getTeamById(id);
        if (team.isPresent()) {
            return team;
        }
        return Optional.empty();
    }


    public List<Long> getMissingPlayerIds(List<Long> idPlayers) {
        List<Long> existingPlayerIds = teamOutputPort.findExistingPlayerIds(idPlayers);
        List<Long> missingPlayerIds = new ArrayList<>(idPlayers);
        missingPlayerIds.removeAll(existingPlayerIds);
        return missingPlayerIds;
    }

}

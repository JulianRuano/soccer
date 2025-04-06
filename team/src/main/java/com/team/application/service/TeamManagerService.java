package com.team.application.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.team.application.port.ITeamManagerInputPort;
import com.team.domain.model.Player;
import com.team.domain.model.Team;
import com.team.domain.port.IFormatterResultOutputPort;
import com.team.domain.port.IPlayerRepositoryPort;
import com.team.domain.port.ITeamManagerOutputPort;
import com.team.domain.port.ITeamRepositoryPort;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TeamManagerService implements ITeamManagerInputPort{

    private final IPlayerRepositoryPort playerOutputPort;
    private final ITeamRepositoryPort teamOutputPort;
    private final ITeamManagerOutputPort teamManagerOutputPort;
    private final IFormatterResultOutputPort formatterResultOutputPort;

    @Override
    public Player addPlayerToTeam(Long teamId, Long playerId) {
        Optional<Player> player = playerOutputPort.getPlayerById(playerId);
        if (!player.isPresent()) {
            formatterResultOutputPort.returnResponseError(404, "Player not found");
        }

        Optional<Team> team = teamOutputPort.getTeamById(teamId);
        if (!team.isPresent()) {
            formatterResultOutputPort.returnResponseError(404, "Team not found");
        }   
         
        team.get().addPlayer(player.get());
        teamManagerOutputPort.addPlayerToTeam(player.get(), teamId);   
        return player.get();
    }
    
    @Override
    public boolean removePlayerFromTeam(Long teamId, Long playerId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'removePlayerFromTeam'");
    }
}

package com.team.application.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.team.application.ports.input.ITeamManagerInputPort;
import com.team.application.ports.output.IFormatterResultOutputPort;
import com.team.application.ports.output.IPlayerOutputPort;
import com.team.application.ports.output.ITeamManagerOutputPort;
import com.team.application.ports.output.ITeamOutputPort;
import com.team.domain.model.Player;
import com.team.domain.model.Team;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TeamManagerService implements ITeamManagerInputPort{

    private final IPlayerOutputPort playerOutputPort;
    private final ITeamOutputPort teamOutputPort;
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

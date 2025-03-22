package com.hexagonal.soccer.application.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.hexagonal.soccer.application.ports.input.ITeamManagerInputPort;
import com.hexagonal.soccer.application.ports.output.IPlayerOutputPort;
import com.hexagonal.soccer.application.ports.output.ITeamManagerOutputPort;
import com.hexagonal.soccer.application.ports.output.ITeamOutputPort;
import com.hexagonal.soccer.domain.model.Player;
import com.hexagonal.soccer.domain.model.Team;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TeamManagerService implements ITeamManagerInputPort{

    private final IPlayerOutputPort playerOutputPort;
    private final ITeamOutputPort teamOutputPort;
    private final ITeamManagerOutputPort teamManagerOutputPort;

    @Override
    public Player addPlayerToTeam(Long teamId, Long playerId) {
        Optional<Player> player = playerOutputPort.getPlayerById(playerId);
        if (player.isPresent()) {
            Optional<Team> team = teamOutputPort.getTeamById(teamId);
            if (team.isPresent()) {
                team.get().addPlayer(player.get());
                teamManagerOutputPort.addPlayerToTeam(player.get(), teamId);
                return player.get();
            }

        }
        return null;
    }
    @Override
    public boolean removePlayerFromTeam(Long teamId, Long playerId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'removePlayerFromTeam'");
    }
}

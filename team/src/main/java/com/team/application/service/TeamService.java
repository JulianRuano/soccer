package com.team.application.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.team.application.ports.input.ITeamInputPort;
import com.team.application.ports.output.IPlayerOutputPort;
import com.team.application.ports.output.ITeamOutputPort;
import com.team.domain.model.Player;
import com.team.domain.model.Team;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TeamService implements ITeamInputPort {
    
    private final IPlayerOutputPort playerOutputPort;
    private final ITeamOutputPort teamOutputPort;

    @Override
    public Team createTeam(Team team, List<Long> idPlayers) {
        // buscar jugadores por id
        List<Player> players = new ArrayList<>();
        idPlayers.forEach(id -> {
            Optional<Player> player = playerOutputPort.getPlayerById(id);
            if (player.isPresent()) {
                players.add(player.get());
            }
        });
        team.setPlayers(players);

        return teamOutputPort.createTeam(team);
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

}

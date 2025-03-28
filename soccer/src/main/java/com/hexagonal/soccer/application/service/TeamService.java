package com.hexagonal.soccer.application.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.hexagonal.soccer.application.ports.input.ITeamInputPort;
import com.hexagonal.soccer.domain.model.Player;
import com.hexagonal.soccer.domain.model.Team;
import com.hexagonal.soccer.domain.port.IPlayerRepositoryPort;
import com.hexagonal.soccer.domain.port.ITeamRepositoryPort;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TeamService implements ITeamInputPort {
    
    private final IPlayerRepositoryPort playerOutputPort;
    private final ITeamRepositoryPort teamOutputPort;

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

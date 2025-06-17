package com.team.infrastructure.adapters.output.jpa.adapter;

import org.springframework.stereotype.Service;

import com.team.domain.model.Player;
import com.team.domain.port.ITeamManagerOutputPort;
import com.team.infrastructure.adapters.output.jpa.entity.PlayerEntity;
import com.team.infrastructure.adapters.output.jpa.entity.TeamEntity;
import com.team.infrastructure.adapters.output.jpa.mapper.PlayerEntityMapper;
import com.team.infrastructure.adapters.output.jpa.repository.IPlayerRepository;
import com.team.infrastructure.adapters.output.jpa.repository.ITeamRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TeamManagerJpaAdapter implements ITeamManagerOutputPort {

    private final ITeamRepository teamRepository;
    private final IPlayerRepository playerRepository;   
    private final PlayerEntityMapper playerEntityMapper;

    @Override
    public Player addPlayerToTeam(Player player, Long teamId) {
        PlayerEntity playerEntity = playerRepository.findById(player.getId())
            .orElseThrow(() -> new EntityNotFoundException("Player not found with id: " + player.getId()));

        if (!teamRepository.existsById(teamId)) {
            throw new EntityNotFoundException("Team not found with id: " + teamId);
        }

        TeamEntity teamRef = teamRepository.getReferenceById(teamId);
        playerEntity.setTeam(teamRef);
        playerRepository.save(playerEntity);

        return playerEntityMapper.toDomain(playerEntity);
    }


    @Override
    public Player removePlayerFromTeam(Player player, Long teamId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'removePlayerFromTeam'");
    }
  
    
}

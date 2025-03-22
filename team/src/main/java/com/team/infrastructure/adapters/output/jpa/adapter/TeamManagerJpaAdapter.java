package com.team.infrastructure.adapters.output.jpa.adapter;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.team.application.ports.output.ITeamManagerOutputPort;
import com.team.domain.model.Player;
import com.team.infrastructure.adapters.output.jpa.entity.PlayerEntity;
import com.team.infrastructure.adapters.output.jpa.entity.TeamEntity;
import com.team.infrastructure.adapters.output.jpa.mapper.PlayerEntityMapper;
import com.team.infrastructure.adapters.output.jpa.repository.IPlayerRepository;
import com.team.infrastructure.adapters.output.jpa.repository.ITeamRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TeamManagerJpaAdapter implements ITeamManagerOutputPort {

    private final ITeamRepository teamRepository;
    private final IPlayerRepository playerRepository;   
    private final PlayerEntityMapper playerEntityMapper;

    @Override
    public Player addPlayerToTeam(Player player, Long teamId) {
        Optional<PlayerEntity> playerOptional = playerRepository.findById(player.getId());
        if (playerOptional.isPresent()) {
            Optional<TeamEntity> teamOptional = teamRepository.findById(teamId);
            if (teamOptional.isPresent()) {
                
                playerOptional.get().setTeam(teamOptional.get());
                playerRepository.save(playerOptional.get());
                return playerEntityMapper.toDomain(playerOptional.get());
            }
        }
        return null;
    }

    @Override
    public Player removePlayerFromTeam(Player player, Long teamId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'removePlayerFromTeam'");
    }
  
    
}

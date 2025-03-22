package com.team.infrastructure.adapters.output.jpa.adapter;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.team.application.ports.output.IPlayerOutputPort;
import com.team.domain.model.Player;
import com.team.infrastructure.adapters.output.jpa.entity.PlayerEntity;
import com.team.infrastructure.adapters.output.jpa.mapper.PlayerEntityMapper;
import com.team.infrastructure.adapters.output.jpa.repository.IPlayerRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class PlayerJpaAdapter implements IPlayerOutputPort {

    private final IPlayerRepository playerRepository;
    
    private final PlayerEntityMapper playerEntityMapper;

    @Override
    public Player createPlayer(Player player) {
        PlayerEntity playerEntity = playerEntityMapper.toEntity(player);
        Player savedPlayer = playerEntityMapper.toDomain(playerRepository.save(playerEntity));
        return savedPlayer;
    }

    @Override
    public Player updatePlayer(Long id, Player player) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updatePlayer'");
    }

    @Override
    public Optional<Player> getPlayerById(Long id) {
        Optional<PlayerEntity> playerEntity = playerRepository.findById(id);
        return playerEntity.map(playerEntityMapper::toDomain);
    }
    
}

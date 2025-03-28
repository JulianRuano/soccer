package com.hexagonal.soccer.infrastructure.adapters.output.jpa.adapter;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.hexagonal.soccer.domain.model.Player;
import com.hexagonal.soccer.domain.port.IPlayerRepositoryPort;
import com.hexagonal.soccer.infrastructure.adapters.output.jpa.entity.PlayerEntity;
import com.hexagonal.soccer.infrastructure.adapters.output.jpa.mapper.PlayerEntityMapper;
import com.hexagonal.soccer.infrastructure.adapters.output.jpa.repository.IPlayerRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class PlayerJpaAdapter implements IPlayerRepositoryPort {

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

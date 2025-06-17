package com.hexagonal.soccer.infrastructure.adapters.output.jpa.adapter;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hexagonal.soccer.domain.model.Game;
import com.hexagonal.soccer.domain.port.IGameRepositoryPort;
import com.hexagonal.soccer.infrastructure.adapters.output.jpa.mapper.GameEntityMapper;
import com.hexagonal.soccer.infrastructure.adapters.output.jpa.repository.IGameRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GameJpaAdapter implements IGameRepositoryPort {

    private final IGameRepository gameRepository;

    private final GameEntityMapper gameEntityMapper;

    @Override
    public Game createGame(Game game) {
        return gameEntityMapper.toDomain(gameRepository.save(gameEntityMapper.toEntity(game)));      
    }

    @Override
    public List<Game> getAllGames() {
        return gameEntityMapper.toDomainList(gameRepository.findAll());
    }
    
}

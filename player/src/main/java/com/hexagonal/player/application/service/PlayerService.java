package com.hexagonal.player.application.service;

import java.util.Optional;

import org.springframework.stereotype.Service;
import com.hexagonal.player.application.ports.input.IPlayerInputPort;
import com.hexagonal.player.application.ports.output.IPlayerEventPublisherPort;
import com.hexagonal.player.application.ports.output.IPlayerRepositoryPort;
import com.hexagonal.player.domain.model.Player;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PlayerService implements IPlayerInputPort {

    private final IPlayerRepositoryPort playerRepositoryPort;
    private final IPlayerEventPublisherPort playerEventPort;

    @Override
    public Player createPlayer(Player player) {
        Player savedPlayer = playerRepositoryPort.createPlayer(player);
        playerEventPort.publishCreatedPlayer(savedPlayer);
        return savedPlayer;
    }

    @Override
    public Player updatePlayer(Long id, Player player) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updatePlayer'");
    }

    @Override
    public Optional<Player> getPlayerById(Long id) {
        return playerRepositoryPort.getPlayerById(id);
    }
    
}

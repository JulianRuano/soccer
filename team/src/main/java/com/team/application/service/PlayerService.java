package com.team.application.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.team.application.port.IPlayerInputPort;
import com.team.domain.model.Player;
import com.team.domain.port.IPlayerRepositoryPort;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PlayerService implements IPlayerInputPort {

    private final IPlayerRepositoryPort playerOutputPort;

    @Override
    public Player createPlayer(Player player) {
        return playerOutputPort.createPlayer(player);
    }

    @Override
    public Player updatePlayer(Long id, Player player) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updatePlayer'");
    }

    @Override
    public Optional<Player> getPlayerById(Long id) {
        return playerOutputPort.getPlayerById(id);
    }
    
}

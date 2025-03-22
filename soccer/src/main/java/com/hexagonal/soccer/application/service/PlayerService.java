package com.hexagonal.soccer.application.service;

import java.util.Optional;

import org.springframework.stereotype.Service;
import com.hexagonal.soccer.application.ports.input.IPlayerInputPort;
import com.hexagonal.soccer.application.ports.output.IPlayerOutputPort;
import com.hexagonal.soccer.domain.model.Player;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PlayerService implements IPlayerInputPort {

    private final IPlayerOutputPort playerOutputPort;

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

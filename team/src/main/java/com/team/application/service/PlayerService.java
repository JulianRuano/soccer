package com.team.application.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.team.application.ports.input.IPlayerInputPort;
import com.team.application.ports.output.IPlayerOutputPort;
import com.team.domain.model.Player;

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

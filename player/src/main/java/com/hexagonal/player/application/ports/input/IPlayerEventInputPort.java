package com.hexagonal.player.application.ports.input;

import com.hexagonal.player.domain.model.Player;

public interface IPlayerEventInputPort {
    void publishCreatedPlayer(Player player);
}

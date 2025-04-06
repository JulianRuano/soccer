package com.hexagonal.player.application.port;

import com.hexagonal.player.domain.model.Player;

public interface IPlayerEventInputPort {
    void publishCreatedPlayer(Player player);
}

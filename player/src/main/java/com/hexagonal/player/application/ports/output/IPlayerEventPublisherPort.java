package com.hexagonal.player.application.ports.output;

import com.hexagonal.player.domain.model.Player;

public interface IPlayerEventPublisherPort {
    void publishCreatedPlayer(Player player);
}

package com.hexagonal.player.domain.port;

import com.hexagonal.player.domain.model.Player;

public interface IPlayerEventPublisherPort {
    void publishCreatedPlayer(Player player);
}

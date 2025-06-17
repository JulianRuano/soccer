package com.hexagonal.player.infrastructure.adapters.output.messageBroker;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import com.hexagonal.player.domain.model.Player;
import com.hexagonal.player.domain.port.IPlayerEventPublisherPort;
import com.hexagonal.player.infrastructure.adapters.output.messageBroker.dto.EventDto;
import com.hexagonal.player.infrastructure.adapters.output.messageBroker.dto.PlayerDto;
import com.hexagonal.player.infrastructure.adapters.output.messageBroker.enums.EventType;
import com.hexagonal.player.infrastructure.adapters.output.messageBroker.mapper.PlayerEventMapper;
import com.hexagonal.player.infrastructure.config.RabbitConfig;

import lombok.RequiredArgsConstructor;


@Component
@RequiredArgsConstructor
public class PlayerEventPublisher implements IPlayerEventPublisherPort {

    private final RabbitTemplate rabbitTemplate;
    private final PlayerEventMapper playerEventMapper;

    @Override
    public void publishCreatedPlayer(Player player) {
        PlayerDto playerDto = playerEventMapper.toDto(player);
        EventDto<PlayerDto> event = new EventDto<>(EventType.CREATED, playerDto);
        System.out.println("Publishing created player event: " + event.getData().getName() + "Type: " + event.getType());
        rabbitTemplate.convertAndSend(RabbitConfig.PLAYER_EXCHANGE, "", event);
    }

    
}

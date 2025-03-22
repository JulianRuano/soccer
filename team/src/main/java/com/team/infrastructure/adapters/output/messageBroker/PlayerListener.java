package com.team.infrastructure.adapters.output.messageBroker;

import org.springframework.stereotype.Service;

import com.team.application.ports.output.IPlayerOutputPort;
import com.team.domain.model.Player;
import com.team.infrastructure.adapters.output.messageBroker.dto.EventDto;
import com.team.infrastructure.adapters.output.messageBroker.dto.PlayerDto;
import com.team.infrastructure.adapters.output.messageBroker.mapper.PlayerEventMapper;
import com.team.infrastructure.config.RabbitConfig;

import org.springframework.amqp.rabbit.annotation.RabbitListener;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class PlayerListener {

    private final IPlayerOutputPort playerOutputPort;

    private final PlayerEventMapper playerEventMapper;

    @RabbitListener(queues = RabbitConfig.PLAYER_TEAM_QUEUE)
    public void processPlayerTeam(EventDto<PlayerDto> eventDto) {
        log.info("Received event: {}", eventDto.getData().getName() + " Type: " + eventDto.getType());

        Player player = playerEventMapper.toDomain(eventDto.getData());

        switch (eventDto.getType()) {
            case CREATED:
                playerOutputPort.createPlayer(player);
                break;
            case UPDATED:
                
                break;
            default:
        }

    }
}

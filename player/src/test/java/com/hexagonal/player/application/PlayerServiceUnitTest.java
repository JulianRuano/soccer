package com.hexagonal.player.application;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.hexagonal.player.application.service.PlayerService;
import com.hexagonal.player.domain.enums.Position;
import com.hexagonal.player.domain.model.Player;
import com.hexagonal.player.domain.port.IPlayerEventPublisherPort;
import com.hexagonal.player.domain.port.IPlayerRepositoryPort;

public class PlayerServiceUnitTest {
    private IPlayerRepositoryPort repositoryMock;
    private IPlayerEventPublisherPort eventPublisherMock;
    private PlayerService playerService;

    @BeforeEach
    void setUp() {
        repositoryMock = mock(IPlayerRepositoryPort.class);
        eventPublisherMock = mock(IPlayerEventPublisherPort.class);
        playerService = new PlayerService(repositoryMock, eventPublisherMock);
    }

    @Test
    void createPlayer_shouldSavePlayerAndPublishEvent() {

        Player player = new Player("Messi", Position.FORWARD, 99);
        when(repositoryMock.createPlayer(player)).thenReturn(player);

        Player result = playerService.createPlayer(player);

        verify(repositoryMock).createPlayer(player);
        verify(eventPublisherMock).publishCreatedPlayer(player);
        assertEquals("Messi", result.getName());
        assertEquals(Position.FORWARD, result.getPosition());
    }
}

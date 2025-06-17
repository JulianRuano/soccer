package com.hexagonal.player.infrastructure;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import com.hexagonal.player.infrastructure.adapters.output.jpa.entity.PlayerEntity;
import com.hexagonal.player.infrastructure.adapters.output.jpa.repository.IPlayerRepository;
import com.hexagonal.player.infrastructure.adapters.output.messageBroker.PlayerEventPublisher;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.springframework.http.MediaType;


@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class PlayerRestControllerIntegrationTest {
    @Autowired
    private MockMvc mockMvc;

    private String ENDPOINT = "/player/create";

    @Autowired
    private IPlayerRepository playerRepository;

    @MockitoBean
    private PlayerEventPublisher playerEventPublisher;

    @BeforeEach
    void setUp() {
        playerRepository.deleteAll();
    }

 @Test
    void createPlayer_shouldReturnCreatedPlayer() throws Exception {
        String requestBody = """
            {
                "name": "Messi",
                "position": "FORWARD",
                "skill": 95,
                "energy": 80
            }
        """;

        mockMvc.perform(post(ENDPOINT)
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBody))
            .andExpect(status().isCreated())
            .andExpect(jsonPath("$.data.name").value("Messi"))
            .andExpect(jsonPath("$.data.position").value("FORWARD"))
            .andExpect(jsonPath("$.data.skill").value(95))
            .andExpect(jsonPath("$.data.energy").value(80));

        // Verificamos que se haya persistido en la base también
        List<PlayerEntity> players = playerRepository.findAll();
        assertEquals(1, players.size());
        assertEquals("Messi", players.get(0).getName());
    }
}

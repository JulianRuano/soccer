package com.hexagonal.player.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import com.hexagonal.player.domain.enums.Position;
import com.hexagonal.player.domain.model.Player;

public class PlayerUnitTest {
      @Test
    void testTraining() {
        Player player = new Player("Juan", Position.MIDFIELDER, 50);
        player.training();
        assertEquals(51, player.getSkill());
        assertEquals(95, player.getEnergy());
    }

    @Test
    void testRecoverEnergy_LessThan100() {
        Player player = new Player("Carlos", Position.DEFENDER, 40);
        player.training(); // energía = 95
        player.recoverEnergy(); // 95 + (10 + 95) = 200 → maximo  100
        assertEquals(100, player.getEnergy());
    }

    @Test
    void testRecoverEnergy_AlreadyAt100() {
        Player player = new Player("Leo", Position.FORWARD, 99);
        player.recoverEnergy();
        assertEquals(100, player.getEnergy());
    }

    @Test
    void testCanPlay_EnoughEnergy() {
        Player player = new Player("Sergio", Position.DEFENDER, 60);
        assertTrue(player.canPlay());
    }

    @Test
    void testCanPlay_LowEnergy() {
        Player player = new Player("Sergio", Position.DEFENDER, 60);
        for (int i = 0; i < 13; i++) {
            player.training(); 
        }
        assertFalse(player.canPlay());
    }
}

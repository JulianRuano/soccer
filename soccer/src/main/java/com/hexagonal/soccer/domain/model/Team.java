package com.hexagonal.soccer.domain.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Team {
    private Long id;
    private String name;
    private List<Player> players;    
    private Alignment alignment;

    public void trainingTeam() {
        players.forEach(Player::training);
    }

    public boolean isReadyForGame() {
        return players.stream().allMatch(Player::canPlay);
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public void removePlayer(Player player) {
        players.remove(player);
    }
}

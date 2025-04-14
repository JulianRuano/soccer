package com.hexagonal.player.domain.model;

import com.hexagonal.player.domain.enums.Position;

import lombok.Data;

@Data
public class Player {
    private Long id;
    private String name;
    private Position position;
    private int skill;
    private int energy;

    public Player(String name, Position position, int skill) {
        this.name = name;
        this.position = position;
        this.skill = skill;
        this.energy = 100;
    }

    public void training() {
        this.skill += 1;
        this.energy -= 5;
    }

    public void recoverEnergy() {
        this.energy = Math.min(100, 10 + this.energy);
    }

    public boolean canPlay() {
        return this.energy >= 40;
    }
}

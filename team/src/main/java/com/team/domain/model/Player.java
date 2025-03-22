package com.team.domain.model;

import lombok.Data;

@Data
public class Player {
    private Long id;
    private String name;

    public Player(String name) {
        this.name = name;
    }

}

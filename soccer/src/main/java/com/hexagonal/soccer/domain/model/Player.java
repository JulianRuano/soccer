package com.hexagonal.soccer.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Player {
    private Long id;
    private String name;

    public Player(String name) {
        this.name = name;
    }

    private Team team;

}

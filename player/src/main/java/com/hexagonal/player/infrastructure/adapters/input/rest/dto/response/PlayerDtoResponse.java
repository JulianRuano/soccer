package com.hexagonal.player.infrastructure.adapters.input.rest.dto.response;

import com.hexagonal.player.domain.enums.Position;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PlayerDtoResponse {
    private Long id;
    private String name;
    private Position position;
    private int skill;
    private int energy;
}

package com.hexagonal.player.infrastructure.adapters.input.rest.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hexagonal.player.domain.enums.Position;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PlayerDtoRequest {
    @JsonIgnore
    private Long id;
    private String name;
    private Position position;
    private int skill;
    private int energy;

}

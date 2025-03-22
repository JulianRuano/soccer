package com.hexagonal.soccer.infrastructure.adapters.input.rest.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import com.hexagonal.soccer.domain.enums.Position;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PlayerDtoRequest {

    private String name;
    private Position position;
    private int skill;
}

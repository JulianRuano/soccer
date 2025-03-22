package com.hexagonal.soccer.infrastructure.adapters.input.rest.dto.response;

import java.util.List;

import com.hexagonal.soccer.domain.model.Player;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TeamDtoResponse {
    private Long id;
    private String name;
    private List<Player> players;    
    private String alignment;
}

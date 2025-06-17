package com.team.infrastructure.adapters.input.rest.dto.response;

import java.util.List;

import com.team.domain.model.Player;

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
}

package com.hexagonal.soccer.infrastructure.adapters.input.rest.dto.response;

import com.hexagonal.soccer.domain.model.Team;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GameDtoResponse {
    private Long id;
    private Team localTeam;
    private Team visitorTeam;
    private int localGoals;
    private int visitorGoals;
    private boolean finished;
}

package com.team.infrastructure.adapters.input.rest.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GameDtoRequest {
    private Long localTeamId;
    private Long visitorTeamId;
}

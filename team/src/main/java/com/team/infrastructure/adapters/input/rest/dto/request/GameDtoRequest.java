package com.team.infrastructure.adapters.input.rest.dto.request;

import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GameDtoRequest {
    @PositiveOrZero(message = "{game.localTeamId.positive}")
    private Long localTeamId;

    @PositiveOrZero(message = "{game.visitorTeamId.positive}")
    private Long visitorTeamId;
}

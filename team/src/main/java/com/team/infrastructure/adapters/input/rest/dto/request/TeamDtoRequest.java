package com.team.infrastructure.adapters.input.rest.dto.request;

import java.util.List;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TeamDtoRequest {
    @NotBlank(message = "{team.name.notBlank}")
    private String name;

    private List<Long> idPlayers;
}

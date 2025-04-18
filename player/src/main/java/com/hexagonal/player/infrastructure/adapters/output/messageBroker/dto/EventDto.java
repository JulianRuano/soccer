package com.hexagonal.player.infrastructure.adapters.output.messageBroker.dto;

import com.hexagonal.player.infrastructure.adapters.output.messageBroker.enums.EventType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EventDto<T> {
    private EventType type;
    private T data;
}

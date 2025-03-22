package com.team.infrastructure.adapters.output.messageBroker.dto;

import com.team.infrastructure.adapters.output.messageBroker.enums.EventType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventDto<T> {
    private EventType type;
    private T data;
}

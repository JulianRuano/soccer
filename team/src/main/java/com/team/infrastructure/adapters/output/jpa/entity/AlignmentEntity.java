package com.team.infrastructure.adapters.output.jpa.entity;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AlignmentEntity {
    
    private String scheme;

}

package com.team.infrastructure.adapters.output.jpa.entity;

import jakarta.persistence.Embeddable;

@Embeddable
public class AlignmentEntity {
    
    private String scheme;

    public AlignmentEntity(String scheme) {
        this.scheme = scheme;
    }

    public String getScheme() {
        return scheme;
    }
}

package com.hexagonal.soccer.infrastructure.adapters.output.jpa.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "game")
public class GameEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "game_id")
    private Long id;

    private int localGoals;
    private int visitorGoals;
    private boolean finished;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "local_team_id")
    private TeamEntity localTeam;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "visitor_team_id")
    private TeamEntity visitorTeam;

    @Column(name = "tenant_id", nullable = false)
    private String tenantId;  
}

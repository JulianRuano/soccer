package com.hexagonal.soccer.infrastructure.adapters.output.jpa.entity;

import java.util.List;

import org.hibernate.annotations.TenantId;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "team")
public class TeamEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "team_id")
    private Long id;

    private String name;
 
    @OneToMany(mappedBy = "team")
    private List<PlayerEntity> players;  

    @OneToMany(mappedBy = "localTeam")
    private List<GameEntity> localGames;

    @OneToMany(mappedBy = "visitorTeam")
    private List<GameEntity> visitorGames;

    @TenantId
    private String tenantId;    
}

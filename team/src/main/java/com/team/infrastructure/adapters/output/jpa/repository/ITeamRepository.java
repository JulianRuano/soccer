package com.team.infrastructure.adapters.output.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.team.infrastructure.adapters.output.jpa.entity.TeamEntity;

public interface ITeamRepository extends JpaRepository<TeamEntity, Long> {
    
}

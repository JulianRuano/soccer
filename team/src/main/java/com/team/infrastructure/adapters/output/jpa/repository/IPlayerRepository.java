package com.team.infrastructure.adapters.output.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.team.infrastructure.adapters.output.jpa.entity.PlayerEntity;

public interface IPlayerRepository extends JpaRepository<PlayerEntity, Long> {
    
}

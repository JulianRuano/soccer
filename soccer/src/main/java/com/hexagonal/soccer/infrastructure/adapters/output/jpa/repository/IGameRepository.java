package com.hexagonal.soccer.infrastructure.adapters.output.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hexagonal.soccer.infrastructure.adapters.output.jpa.entity.GameEntity;

public interface IGameRepository extends JpaRepository<GameEntity, Long> {

}

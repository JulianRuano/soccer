package com.team.infrastructure.adapters.output.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.team.infrastructure.adapters.output.jpa.entity.TeamEntity;

public interface ITeamRepository extends JpaRepository<TeamEntity, Long> {

    @Query("SELECT id FROM PlayerEntity WHERE id IN :idPlayers")
    List<Long> findExistingPlayerIds(@Param("idPlayers") List<Long> idPlayers);
    
}

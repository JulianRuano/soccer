package com.hexagonal.soccer.infrastructure.adapters.output.jpa.adapter;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.hexagonal.soccer.application.ports.output.ITeamOutputPort;
import com.hexagonal.soccer.domain.model.Team;
import com.hexagonal.soccer.infrastructure.adapters.output.jpa.entity.TeamEntity;
import com.hexagonal.soccer.infrastructure.adapters.output.jpa.mapper.TeamEntityMapper;
import com.hexagonal.soccer.infrastructure.adapters.output.jpa.repository.ITeamRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class TeamJpaAdapter implements ITeamOutputPort {

    private final ITeamRepository teamRepository;

    private final TeamEntityMapper teamEntityMapper;

    @Override
    public Team createTeam(Team team) {
        TeamEntity teamEntity = teamEntityMapper.toEntity(team);
        
        Team savedTeam = teamEntityMapper.toDomain(teamRepository.save(teamEntity));
        return savedTeam;
    }
    @Override
    public Team updateTeam(Long id, Team team) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateTeam'");
    }

    @Override
    public Optional<Team> getTeamById(Long id) {
        Optional<TeamEntity> teamEntity = teamRepository.findById(id);
        return teamEntity.map(teamEntityMapper::toDomain);
    }


    
}
    


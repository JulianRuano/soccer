package com.team.infrastructure.adapters.output.seeder;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.team.infrastructure.adapters.output.jpa.entity.AlignmentEntity;
import com.team.infrastructure.adapters.output.jpa.entity.TeamEntity;
import com.team.infrastructure.adapters.output.jpa.repository.ITeamRepository;

import java.util.ArrayList;
import java.util.Arrays;

@Component
@Profile("dev")
@RequiredArgsConstructor
@Slf4j
public class DataSeeder {

    private final ITeamRepository teamRepository;

    @PostConstruct
    public void seed() {
        try {
            if (teamRepository.count() == 0) {
                TeamEntity red = new TeamEntity(null, "Red Team", new AlignmentEntity("Offensive"), new ArrayList<>());
                TeamEntity blue = new TeamEntity(null, "Blue Team", new AlignmentEntity("Defensive"), new ArrayList<>());

                teamRepository.saveAll(Arrays.asList(red, blue));
                log.info("Datos de prueba insertados.");
            } else {
                log.info("Datos ya existentes. Seeder no ejecutado.");
            }
        } catch (Exception e) {
            log.error("Error en DataSeeder", e);
            throw e;
        }
    }
}

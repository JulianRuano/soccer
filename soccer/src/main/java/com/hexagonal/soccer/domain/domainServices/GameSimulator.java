package com.hexagonal.soccer.domain.domainServices;

import org.springframework.stereotype.Service;

import com.hexagonal.soccer.domain.model.Game;
import com.hexagonal.soccer.domain.model.Player;
import com.hexagonal.soccer.domain.model.Team;

@Service
public class GameSimulator {
    
    public Game simulateGame(Team localTeam, Team visitorTeam){
        Game game = new Game(localTeam, visitorTeam);

        int localPower = calculatePowerTeam(localTeam);
        int visitorPower = calculatePowerTeam(visitorTeam);

        int localGoals = calculateGoals(localPower);
        int visitorGoals = calculateGoals(visitorPower);

        game.playGame(localGoals, visitorGoals);
        return game;
    }

    private int calculatePowerTeam(Team team){
        return team.getPlayers().stream().mapToInt(Player::getSkill).sum();
    }

    private int calculateGoals(int power){
        return (int) (Math.random() * (power / 100.0) * 5);
    }
    

}

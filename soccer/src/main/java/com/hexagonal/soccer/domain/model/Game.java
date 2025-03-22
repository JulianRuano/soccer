package com.hexagonal.soccer.domain.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Game {
    private Long id;
    private Team localTeam;
    private Team visitorTeam;
    private int localGoals;
    private int visitorGoals;
    private boolean finished;

    public Game(Team localTeam, Team visitorTeam) {
        this.localTeam = localTeam;
        this.visitorTeam = visitorTeam;
        this.localGoals = 0;
        this.visitorGoals = 0;
        this.finished = false;
    }

    public void playGame(Integer local, Integer visitor){
        if (!localTeam.isReadyForGame() || !visitorTeam.isReadyForGame()){
            throw new RuntimeException("Teams are not ready for the game");
        }
        localGoals = local;
        visitorGoals = visitor;
        finished = true;
    }

    public String getWinner(){
        if (!finished){
            throw new RuntimeException("Game is not finished yet");
        }
        if (localGoals > visitorGoals){
            return localTeam.getName();
        } else if (localGoals < visitorGoals){
            return visitorTeam.getName();
        } else {
            return "Draw";
        }
    }

    public String result(){
        return finished ? localTeam.getName() + " " + localGoals + " - " + visitorGoals + " " + visitorTeam.getName() : "Game not finished yet";
    }


}

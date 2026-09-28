package com.soul.esportsteam.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "player_statistics")
public class PlayerStatistics {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String playerName;
    private String tournament;

    private Integer matches;
    private Integer kills;
    private Integer wins;

    private Integer tournamentRank;

    private Integer careerMatches;
    private Integer careerFinishes;


    public Long getId() {
        return id;
    }


    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }


    public String getTournament() {
        return tournament;
    }

    public void setTournament(String tournament) {
        this.tournament = tournament;
    }


    public Integer getMatches() {
        return matches;
    }

    public void setMatches(Integer matches) {
        this.matches = matches;
    }


    public Integer getKills() {
        return kills;
    }

    public void setKills(Integer kills) {
        this.kills = kills;
    }


    public Integer getWins() {
        return wins;
    }

    public void setWins(Integer wins) {
        this.wins = wins;
    }


    public Integer getTournamentRank() {
        return tournamentRank;
    }

    public void setTournamentRank(Integer tournamentRank) {
        this.tournamentRank = tournamentRank;
    }


    public Integer getCareerMatches() {
        return careerMatches;
    }

    public void setCareerMatches(Integer careerMatches) {
        this.careerMatches = careerMatches;
    }


    public Integer getCareerFinishes() {
        return careerFinishes;
    }

    public void setCareerFinishes(Integer careerFinishes) {
        this.careerFinishes = careerFinishes;
    }
}
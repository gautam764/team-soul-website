package com.soul.esportsteam.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "ai_results")
public class AIResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tournament;
    private String matchDay;
    private String teamName;

    @Column(name = "overall_rank")
    private Integer rank;

    private Integer matches;
    private Integer wins;
    private Integer eliminations;
    private Integer placementPoints;
    private Integer totalPoints;

    public Long getId() {
        return id;
    }

    public String getTournament() {
        return tournament;
    }

    public void setTournament(String tournament) {
        this.tournament = tournament;
    }

    public String getMatchDay() {
        return matchDay;
    }

    public void setMatchDay(String matchDay) {
        this.matchDay = matchDay;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public Integer getMatches() {
        return matches;
    }

    public void setMatches(Integer matches) {
        this.matches = matches;
    }

    public Integer getWins() {
        return wins;
    }

    public void setWins(Integer wins) {
        this.wins = wins;
    }

    public Integer getEliminations() {
        return eliminations;
    }

    public void setEliminations(Integer eliminations) {
        this.eliminations = eliminations;
    }

    public Integer getPlacementPoints() {
        return placementPoints;
    }

    public void setPlacementPoints(Integer placementPoints) {
        this.placementPoints = placementPoints;
    }

    public Integer getTotalPoints() {
        return totalPoints;
    }

    public void setTotalPoints(Integer totalPoints) {
        this.totalPoints = totalPoints;
    }
}
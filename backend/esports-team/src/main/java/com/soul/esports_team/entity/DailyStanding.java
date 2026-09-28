package com.soul.esportsteam.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "daily_standings")
public class DailyStanding {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tournament;
    private String matchDay;
    private Integer matchNumber;
    private String teamName;

    @Column(name = "overall_rank")
    private Integer rank;

    private Integer finishPoints;
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

    public Integer getMatchNumber() {
        return matchNumber;
    }

    public void setMatchNumber(Integer matchNumber) {
        this.matchNumber = matchNumber;
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

    public Integer getFinishPoints() {
        return finishPoints;
    }

    public void setFinishPoints(Integer finishPoints) {
        this.finishPoints = finishPoints;
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
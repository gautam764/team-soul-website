package com.soul.esportsteam.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "matches")
public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tournament;
    private String stage;
    private String matchDay;

    private Integer matchNumber;

    private String teamName;

    private LocalDate matchDate;
    private LocalTime matchTime;

    private Integer finishPoints;
    private Integer placementPoints;

    private String status;

    public Long getId() {
        return id;
    }

    public String getTournament() {
        return tournament;
    }

    public void setTournament(String tournament) {
        this.tournament = tournament;
    }

    public String getStage() {
        return stage;
    }

    public void setStage(String stage) {
        this.stage = stage;
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

    public LocalDate getMatchDate() {
        return matchDate;
    }

    public void setMatchDate(LocalDate matchDate) {
        this.matchDate = matchDate;
    }

    public LocalTime getMatchTime() {
        return matchTime;
    }

    public void setMatchTime(LocalTime matchTime) {
        this.matchTime = matchTime;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
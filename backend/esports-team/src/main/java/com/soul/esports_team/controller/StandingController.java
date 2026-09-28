package com.soul.esportsteam.controller;

import com.soul.esportsteam.entity.Match;
import com.soul.esportsteam.repository.MatchRepository;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/standings")
@CrossOrigin(origins = "*")
public class StandingController {

    private final MatchRepository repository;

    public StandingController(MatchRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Map<String, Object>> getStandings(
            @RequestParam String tournament,
            @RequestParam String matchDay) {

        List<Match> matches = repository.findAll();

        Map<String, Map<String, Object>> teams = new HashMap<>();

        for (Match match : matches) {

            if (!tournament.equals(match.getTournament())) {
                continue;
            }

            if (!matchDay.equals(match.getMatchDay())) {
                continue;
            }

            if (!"COMPLETED".equalsIgnoreCase(match.getStatus())) {
                continue;
            }

            String teamName = match.getTeamName();

            if (teamName == null || teamName.trim().isEmpty()) {
                continue;
            }

            teams.putIfAbsent(teamName, new HashMap<>());

            Map<String, Object> team = teams.get(teamName);

            int finishPoints =
                    match.getFinishPoints() != null
                    ? match.getFinishPoints()
                    : 0;

            int placementPoints =
                    match.getPlacementPoints() != null
                    ? match.getPlacementPoints()
                    : 0;

            int currentFinish =
                    team.get("finishPoints") != null
                    ? (Integer) team.get("finishPoints")
                    : 0;

            int currentPlacement =
                    team.get("placementPoints") != null
                    ? (Integer) team.get("placementPoints")
                    : 0;

            int matchesPlayed =
                    team.get("matchesPlayed") != null
                    ? (Integer) team.get("matchesPlayed")
                    : 0;

            team.put("team", teamName);

            team.put(
                    "matchesPlayed",
                    matchesPlayed + 1
            );

            team.put(
                    "finishPoints",
                    currentFinish + finishPoints
            );

            team.put(
                    "placementPoints",
                    currentPlacement + placementPoints
            );

            team.put(
                    "totalPoints",
                    currentFinish
                            + finishPoints
                            + currentPlacement
                            + placementPoints
            );
        }

        List<Map<String, Object>> standings =
                new ArrayList<>(teams.values());

        standings.sort(
                (a, b) ->
                        Integer.compare(
                                (Integer) b.get("totalPoints"),
                                (Integer) a.get("totalPoints")
                        )
        );

        for (int i = 0; i < standings.size(); i++) {

            standings.get(i).put(
                    "rank",
                    i + 1
            );
        }

        return standings;
    }
}
package com.soul.esportsteam.controller;

import com.soul.esportsteam.entity.DailyStanding;
import com.soul.esportsteam.repository.DailyStandingRepository;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/daily-standings")
@CrossOrigin(origins = "*")
public class DailyStandingController {

    private final DailyStandingRepository repository;

    public DailyStandingController(
            DailyStandingRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/all")
    public List<DailyStanding> getAllStandings() {
        return repository.findAll();
    }

    @GetMapping
    public List<DailyStanding> getStandings(
            @RequestParam String tournament,
            @RequestParam String matchDay) {

        return repository
                .findByTournamentAndMatchDayOrderByMatchNumberAscRankAsc(
                        tournament,
                        matchDay
                );
    }

    @PostMapping
    public DailyStanding addStanding(
            @RequestBody DailyStanding standing) {

        return repository.save(standing);
    }

    @PutMapping("/{id}")
    public DailyStanding updateStanding(
            @PathVariable Long id,
            @RequestBody DailyStanding standing) {

        DailyStanding existing =
                repository.findById(id).orElse(null);

        if (existing == null) {
            return null;
        }

        existing.setTournament(standing.getTournament());
        existing.setMatchDay(standing.getMatchDay());
        existing.setMatchNumber(standing.getMatchNumber());
        existing.setTeamName(standing.getTeamName());
        existing.setRank(standing.getRank());
        existing.setFinishPoints(standing.getFinishPoints());
        existing.setPlacementPoints(standing.getPlacementPoints());
        existing.setTotalPoints(standing.getTotalPoints());

        return repository.save(existing);
    }

    @DeleteMapping("/{id}")
    public void deleteStanding(
            @PathVariable Long id) {

        repository.deleteById(id);
    }
}
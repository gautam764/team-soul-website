package com.soul.esportsteam.controller;

import com.soul.esportsteam.entity.PlayerStatistics;
import com.soul.esportsteam.repository.PlayerStatisticsRepository;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/player-statistics")
@CrossOrigin(origins = "*")
public class PlayerStatisticsController {

    private final PlayerStatisticsRepository repository;

    public PlayerStatisticsController(PlayerStatisticsRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<PlayerStatistics> getAll() {
        return repository.findAll();
    }

    @GetMapping("/player/{playerName}")
    public List<PlayerStatistics> getByPlayer(
            @PathVariable String playerName) {

        return repository.findByPlayerName(playerName);
    }

    @PostMapping
    public PlayerStatistics add(
            @RequestBody PlayerStatistics statistics) {

        return repository.save(statistics);
    }

    @PutMapping("/{id}")
    public PlayerStatistics update(
            @PathVariable Long id,
            @RequestBody PlayerStatistics statistics) {

        PlayerStatistics existing =
                repository.findById(id).orElse(null);

        if (existing == null) {
            return null;
        }

        existing.setPlayerName(statistics.getPlayerName());
        existing.setTournament(statistics.getTournament());
        existing.setMatches(statistics.getMatches());
        existing.setKills(statistics.getKills());
        existing.setWins(statistics.getWins());
        existing.setTournamentRank(statistics.getTournamentRank());

        existing.setCareerMatches(
                statistics.getCareerMatches()
        );

        existing.setCareerFinishes(
                statistics.getCareerFinishes()
        );

        return repository.save(existing);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
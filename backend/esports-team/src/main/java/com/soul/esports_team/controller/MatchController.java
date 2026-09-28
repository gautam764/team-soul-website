package com.soul.esportsteam.controller;

import com.soul.esportsteam.entity.Match;
import com.soul.esportsteam.repository.MatchRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/matches")
@CrossOrigin(origins = "*")
public class MatchController {

    private final MatchRepository repository;

    public MatchController(MatchRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Match> getMatches() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Match getMatch(@PathVariable Long id) {
        return repository.findById(id).orElse(null);
    }

    @PostMapping
    public Match addMatch(@RequestBody Match match) {
        return repository.save(match);
    }

    @PutMapping("/{id}")
    public Match updateMatch(
            @PathVariable Long id,
            @RequestBody Match match) {

        Match existing = repository.findById(id).orElse(null);

        if (existing == null) {
            return null;
        }

        existing.setTournament(match.getTournament());
        existing.setStage(match.getStage());
        existing.setMatchDay(match.getMatchDay());
        existing.setMatchNumber(match.getMatchNumber());
        existing.setTeamName(match.getTeamName());
        existing.setMatchDate(match.getMatchDate());
        existing.setMatchTime(match.getMatchTime());
        existing.setFinishPoints(match.getFinishPoints());
        existing.setPlacementPoints(match.getPlacementPoints());
        existing.setStatus(match.getStatus());

        return repository.save(existing);
    }

    @DeleteMapping("/{id}")
    public void deleteMatch(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
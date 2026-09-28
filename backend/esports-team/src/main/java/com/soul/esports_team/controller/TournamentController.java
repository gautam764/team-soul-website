package com.soul.esportsteam.controller;

import com.soul.esportsteam.entity.Tournament;
import com.soul.esportsteam.repository.TournamentRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tournaments")
@CrossOrigin(origins = "*")
public class TournamentController {

    private final TournamentRepository repository;

    public TournamentController(TournamentRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Tournament> getTournaments() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Tournament getTournament(@PathVariable Long id) {
        return repository.findById(id).orElse(null);
    }

    @PostMapping
    public Tournament addTournament(@RequestBody Tournament tournament) {
        return repository.save(tournament);
    }

    @PutMapping("/{id}")
    public Tournament updateTournament(
            @PathVariable Long id,
            @RequestBody Tournament tournament) {

        Tournament existing = repository.findById(id).orElse(null);

        if (existing == null) {
            return null;
        }

        existing.setName(tournament.getName());
        existing.setYear(tournament.getYear());
        existing.setPosition(tournament.getPosition());
        existing.setPrize(tournament.getPrize());

        return repository.save(existing);
    }

    @DeleteMapping("/{id}")
    public void deleteTournament(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
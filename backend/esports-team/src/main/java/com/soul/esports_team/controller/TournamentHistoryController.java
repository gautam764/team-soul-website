package com.soul.esportsteam.controller;

import com.soul.esportsteam.entity.TournamentHistory;
import com.soul.esportsteam.service.TournamentHistoryService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tournament-history")
@CrossOrigin(origins = "*")
public class TournamentHistoryController {

    private final TournamentHistoryService service;

    public TournamentHistoryController(
            TournamentHistoryService service) {
        this.service = service;
    }

    @GetMapping
    public List<TournamentHistory> getAll() {
        return service.getAll();
    }

    @PostMapping("/seed")
    public List<TournamentHistory> seed() {
        return service.seedHistory();
    }
}
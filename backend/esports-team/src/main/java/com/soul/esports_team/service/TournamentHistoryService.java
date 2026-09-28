package com.soul.esportsteam.service;

import com.soul.esportsteam.entity.TournamentHistory;
import com.soul.esportsteam.repository.TournamentHistoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TournamentHistoryService {

    private final TournamentHistoryRepository repository;

    public TournamentHistoryService(
            TournamentHistoryRepository repository) {
        this.repository = repository;
    }

    public List<TournamentHistory> getAll() {
        return repository.findAll();
    }

    public List<TournamentHistory> seedHistory() {

        add("2026-06-21",
                "Battlegrounds Mobile India Pro Series 2026",
                "13th", "A-Tier", "-");

        add("2026-03-29",
                "Battlegrounds Mobile India Series 2026",
                "1st", "A-Tier", "-");

        add("2025-10-12",
                "Battlegrounds Mobile India Series 2025",
                "3rd", "A-Tier", "-");

        add("2025-07-06",
                "Battlegrounds Mobile India Pro Series 2025",
                "29th", "A-Tier", "-");

        add("2025-04-27",
                "Battlegrounds Mobile India Series 2025",
                "15th", "A-Tier", "-");

        add("2024-09-29",
                "Battlegrounds Mobile India Pro Series 2024",
                "26th", "A-Tier", "-");

        add("2024-06-30",
                "Battlegrounds Mobile India Series 2024",
                "4th", "A-Tier", "-");

        return repository.findAll();
    }

    private void add(
            String date,
            String tournament,
            String place,
            String tier,
            String prize) {

        if (repository.existsByDateAndTournament(
                date, tournament)) {
            return;
        }

        TournamentHistory history =
                new TournamentHistory();

        history.setDate(date);
        history.setTournament(tournament);
        history.setPlace(place);
        history.setTier(tier);
        history.setPrize(prize);

        repository.save(history);
    }
}
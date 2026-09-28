package com.soul.esportsteam.repository;

import com.soul.esportsteam.entity.TournamentHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TournamentHistoryRepository
        extends JpaRepository<TournamentHistory, Long> {

    boolean existsByDateAndTournament(
            String date,
            String tournament
    );
}
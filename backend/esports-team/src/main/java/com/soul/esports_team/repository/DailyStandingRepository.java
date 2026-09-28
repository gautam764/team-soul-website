package com.soul.esportsteam.repository;

import com.soul.esportsteam.entity.DailyStanding;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DailyStandingRepository
        extends JpaRepository<DailyStanding, Long> {

    List<DailyStanding> findByTournamentAndMatchDayOrderByMatchNumberAscRankAsc(
            String tournament,
            String matchDay
    );
}
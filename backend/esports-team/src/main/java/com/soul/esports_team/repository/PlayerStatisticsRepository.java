package com.soul.esportsteam.repository;

import com.soul.esportsteam.entity.PlayerStatistics;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlayerStatisticsRepository
        extends JpaRepository<PlayerStatistics, Long> {

    List<PlayerStatistics> findByPlayerName(
            String playerName
    );
}
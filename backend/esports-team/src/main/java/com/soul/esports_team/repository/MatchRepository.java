package com.soul.esportsteam.repository;

import com.soul.esportsteam.entity.Match;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatchRepository extends JpaRepository<Match, Long> {
}
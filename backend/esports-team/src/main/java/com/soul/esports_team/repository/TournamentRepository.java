package com.soul.esportsteam.repository;

import com.soul.esportsteam.entity.Tournament;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TournamentRepository extends JpaRepository<Tournament, Long> {
}
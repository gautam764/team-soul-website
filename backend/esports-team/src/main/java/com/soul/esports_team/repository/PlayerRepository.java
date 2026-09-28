package com.soul.esportsteam.repository;

import com.soul.esportsteam.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Long> {
}
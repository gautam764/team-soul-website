package com.soul.esportsteam.repository;

import com.soul.esportsteam.entity.News;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewsRepository extends JpaRepository<News, Long> {
}
package com.app.AIRS.repository;

import com.app.AIRS.entity.Markets;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MarketRepository extends JpaRepository<Markets, Long> {
}

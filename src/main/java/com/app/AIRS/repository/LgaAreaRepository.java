package com.app.AIRS.repository;

import com.app.AIRS.entity.lgaArea.LgaAreas;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LgaAreaRepository extends JpaRepository<LgaAreas, Long> {
    List<LgaAreas> findByLgaId(Long id);
}

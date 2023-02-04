package com.app.AIRS.repository;

import com.app.AIRS.entity.Street;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StreetRepository extends JpaRepository<Street, Long> {
    List<Street> findByArea(Long id);
}

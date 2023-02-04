package com.app.AIRS.repository;

import com.app.AIRS.entity.Building_type;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BuildingTypeRepository extends JpaRepository<Building_type, Long> {
    Building_type findFirstByNameIgnoreCase(String type);
}

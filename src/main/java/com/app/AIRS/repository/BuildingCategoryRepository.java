package com.app.AIRS.repository;

import com.app.AIRS.entity.Building_category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BuildingCategoryRepository extends JpaRepository<Building_category, Long> {

    @Query(value="SELECT * FROM BUILDING_CATEGORY WHERE BUILDING_TYPE = :id", nativeQuery = true)
    List<Building_category> findAllByType(Long id);

    Building_category findFirstByNameIgnoreCase(String category);
}

package com.app.AIRS.repository;

import com.app.AIRS.entity.Occupant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OccupantRepository extends JpaRepository<Occupant, Long> {

    List<Occupant> findAllByPropertyId(Long id);
}

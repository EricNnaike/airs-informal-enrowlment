package com.app.AIRS.repository;

import com.app.AIRS.entity.AssessmentTypes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AssessmentTypeRepository extends JpaRepository<AssessmentTypes, Long> {
    List<AssessmentTypes> findByAssessments(Long id);
}

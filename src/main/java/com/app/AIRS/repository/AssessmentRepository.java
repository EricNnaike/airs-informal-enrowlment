package com.app.AIRS.repository;

import com.app.AIRS.entity.Assessments;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssessmentRepository extends JpaRepository<Assessments, Long> {
}

package com.app.AIRS.entity;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "ASSESSMENTS_TYPES")
public class AssessmentTypes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(name = "ASSESSMENT_ID")
    private Long assessments;

    private Long lgaId;
    private Long category;
    private Double amount;
}

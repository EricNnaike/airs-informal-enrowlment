package com.app.AIRS.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "ASSESSMENTS")
public class Assessments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
}

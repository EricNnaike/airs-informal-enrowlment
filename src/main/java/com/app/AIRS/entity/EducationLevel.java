package com.app.AIRS.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@NoArgsConstructor
@Data
@Entity
@Table(name = "EDUCATION_LEVEL")
public class EducationLevel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "SCHOOL_LEVEL")
    private String schoolLevel;

    @Column(name = "DEGREE")
    private String degree;

    @Column(name = "DESCRIPTION")
    private String description;

    @CreationTimestamp
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME, pattern = "yyyy-MM-dd h:m:s")
    @Column(name = "TIME_CREATED")
    private LocalDateTime timeCreated;

    public EducationLevel(Long id) {
        this.id = id;
    }

    public EducationLevel(String schoolLevel, String degree, String description) {
        this.schoolLevel = schoolLevel;
        this.degree = degree;
        this.description = description;
    }


}

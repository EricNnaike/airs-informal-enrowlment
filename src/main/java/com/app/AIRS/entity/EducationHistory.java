package com.app.AIRS.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@NoArgsConstructor
@Data
@Entity
@Table(name = "EDUCATION_HISTORY")
public class EducationHistory implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "USER_ID", referencedColumnName = "id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "EDUCATION_LEVEL", referencedColumnName = "id")
    private EducationLevel educationLevel;

    @Column(name = "SCHOOL_NAME")
    private String schoolName;

    @Column(name = "COURSE_FIELD")
    private String courseField;

    @Column(name = "START_DATE")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME, pattern = "yyyy-MM-dd")
    private LocalDate startDate;

    @Column(name = "END_DATE")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME, pattern = "yyyy-MM-dd")
    private LocalDate endDate;

    @CreationTimestamp
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME, pattern = "yyyy-MM-dd h:m:s")
    @Column(name = "TIME_CREATED")
    private LocalDateTime timeCreated;

    @UpdateTimestamp
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME, pattern = "yyyy-MM-dd h:m:s")
    @Column(name = "TIME_UPDATED")
    private LocalDateTime timeUpdated;

    @Column(name = "IS_DELETED", nullable = false)
    private boolean deleted = false;

    public EducationHistory(User user, EducationLevel educationLevel, String schoolName, String courseField, LocalDate startDate, LocalDate endDate) {
        this.user = user;
        this.educationLevel = educationLevel;
        this.schoolName = schoolName;
        this.courseField = courseField;
        this.startDate = startDate;
        this.endDate = endDate;
    }



}

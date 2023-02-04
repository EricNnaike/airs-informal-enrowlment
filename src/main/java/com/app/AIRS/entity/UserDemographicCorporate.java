package com.app.AIRS.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "USER_DEMOGRAPHIC_CORPORATE")
public class UserDemographicCorporate implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID", referencedColumnName = "id")
    private User user;

    @Column(name = "CORPORATE_NAME")
    private String corporateName;

    @Column(name = "CORPORATE_RC_NUMBER")
    private String corporateRcNumber;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE, pattern = "yyyy-MM-dd")
    @Column(name = "BUSINESS_COMMENCEMENT_DATE")
    private LocalDate businessCommencementDate;

    @Column(name = "REGISTRATION_APPROVED")
    private Boolean registrationApproved;

    @Column(name = "COMPANY_TYPE")
    private String companyTypeName;

    @Column(name = "CLASSIFICATION")
    private String classification;

    @Column(name = "NATURE_OF_BUSINESS_NAME")
    private String natureOfBusinessName;

    @Column(name = "OBJECTIVES")
    private String objectives;

    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;

    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "BRANCH_ADDRESS")
    private String branchAddress;

    @Column(name = "HEAD_OFFICE_ADDRESS")
    private String headOfficeAddress;

    @Column(name = "CITY")
    private String city;

    @Column(name = "LEGACY")
    private Boolean legacy = false;

    @Column(name = "LGA_ID")
    private Long lgaId;

    @Column(name = "STATE_ID")
    private Long stateId;

    @Column(name = "DELISTING_STATUS")
    private String delistingStatus;

    @CreationTimestamp
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME, pattern = "yyyy-MM-dd h:m:s")
    @Column(name = "TIME_CREATED")
    private LocalDateTime timeCreated;

    @UpdateTimestamp
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME, pattern = "yyyy-MM-dd h:m:s")
    @Column(name = "TIME_UPDATED")
    private LocalDateTime timeUpdated;

    private String photo;
}

package com.app.AIRS.entity;

import com.app.AIRS.entity.userManagement.PortalUser;
import com.app.AIRS.entity.userManagement.StatusEntity;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "OCCUPANT")
public class Occupant extends StatusEntity {

    private String occupantType;
    private String residentType;
    private String premises;
    private String presumptive;
    private String waste;
    private String fire;
    private Long premisesId;
    private Long presumptiveId;
    private Long wasteId;
    private Long fireId;
    @ManyToOne
    private Property property;
    private String firstName;
    private String lastName;
    private String address;
    private String others;
    private String phoneNumber;
    private String more;
    private String asin;

    @ManyToOne
    @JoinColumn(name = "NIN_ID", referencedColumnName = "id")
    private NIN nin;

    @CreationTimestamp
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME, pattern = "yyyy-MM-dd h:m:s")
    @Column(name = "TIME_CREATED")
    private LocalDateTime timeCreated;

    @UpdateTimestamp
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME, pattern = "yyyy-MM-dd h:m:s")
    @Column(name = "TIME_UPDATED")
    private LocalDateTime timeUpdated;
}

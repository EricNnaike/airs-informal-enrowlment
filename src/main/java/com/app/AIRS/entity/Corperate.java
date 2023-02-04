package com.app.AIRS.entity;

import com.app.AIRS.entity.userManagement.PortalUser;
import com.app.AIRS.entity.userManagement.StatusEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "COPERATE")
public class Corperate extends StatusEntity {

    private Long lga;
    private Long area;
    private String state;
    private String corperateName;
    private String rcNumber;
    private String companyType;
    private String phonenumber;
    private String email;
    private String address;
    private String street;
    private String landmark;
    private String companyJob;
    private String companyWork;
    private String TinNumber;

    @ManyToOne
    @JoinColumn(name = "PORTALUSER_ID", referencedColumnName = "id")
    private PortalUser portalUser;


    @CreationTimestamp
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME, pattern = "yyyy-MM-dd h:m:s")
    @Column(name = "TIME_CREATED")
    private LocalDateTime timeCreated;

    @UpdateTimestamp
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME, pattern = "yyyy-MM-dd h:m:s")
    @Column(name = "TIME_UPDATED")
    private LocalDateTime timeUpdated;
}

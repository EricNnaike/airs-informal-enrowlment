package com.app.AIRS.entity;

import com.app.AIRS.Enum.UserAccountStatus;
import com.app.AIRS.entity.userManagement.PortalUser;
import com.app.AIRS.entity.userManagement.StatusEntity;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;


@Setter
@Getter
@Entity
@Table(name = "USERS")
public class User extends StatusEntity {


    @ManyToOne
    @JoinColumn(name = "PORTALUSER_ID", referencedColumnName = "id")
    private PortalUser portalUser;

    @ManyToOne
    @JoinColumn(name = "NIN_ID", referencedColumnName = "id")
    private NIN nin;


    @Column(name = "STREET")
    private String streetname;

    @Column(name = "HOUSE_NUMBER")
    private String houseNumber;

    @Column(name = "LANDMARK")
    private String landmark;

    @CreationTimestamp
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME, pattern = "yyyy-MM-dd h:m:s")
    @Column(name = "TIME_CREATED")
    private LocalDateTime timeCreated;

    @UpdateTimestamp
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME, pattern = "yyyy-MM-dd h:m:s")
    @Column(name = "TIME_UPDATED")
    private LocalDateTime timeUpdated;


}

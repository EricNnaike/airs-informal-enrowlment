package com.app.AIRS.entity;

import com.app.AIRS.entity.userManagement.StatusEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "TRANSPORT_DRIVER_USER")
public class TransportDriverUser extends StatusEntity {

    private String name;
    @ManyToOne
    @JoinColumn(name = "TRANSPORT_ID", referencedColumnName = "id")
    private Transport owner;

    @ManyToOne
    @JoinColumn(name = "NIN_ID", referencedColumnName = "id")
    private NIN nin;

    private String firstName;
    private String lastName;
    private String otherName;
    private String phonenumber;
    private String asin;
    private String address;
    private String photo;
    private String email;

    @CreationTimestamp
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME, pattern = "yyyy-MM-dd h:m:s")
    private LocalDateTime timeCreated;

    @UpdateTimestamp
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME, pattern = "yyyy-MM-dd h:m:s")
    private LocalDateTime timeUpdated;
}

package com.app.AIRS.entity;
import com.app.AIRS.Enum.TinStatus;
import com.app.AIRS.Enum.TinType;
import com.app.AIRS.entity.userManagement.PortalUser;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@NoArgsConstructor
@Data
@Entity
@Table(name = "TIN")
public class Tin implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "PORTALUSER_ID", referencedColumnName = "id")
    private PortalUser portalUser;

    @Column(name = "TIN_NUMBER", nullable = false)
    private String tinNumber;

    @Column(name = "TIN_TYPE")
    @Enumerated(EnumType.STRING)
    private TinType tinType;

    @Column(name = "TIN_STATUS")
    @Enumerated(EnumType.STRING)
    private TinStatus tinStatus = TinStatus.ACTIVE;

    @CreationTimestamp
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME, pattern = "yyyy-MM-dd h:m:s")
    @Column(name = "TIME_CREATED")
    private LocalDateTime timeCreated;

    @UpdateTimestamp
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME, pattern = "yyyy-MM-dd h:m:s")
    @Column(name = "TIME_UPDATED")
    private LocalDateTime timeUpdated;


}

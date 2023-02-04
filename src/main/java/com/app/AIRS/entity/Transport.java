package com.app.AIRS.entity;


import com.app.AIRS.Enum.CardType;
import com.app.AIRS.Enum.TransportType;
import com.app.AIRS.entity.userManagement.PortalUser;
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
@Table(name = "TRANSPORT")
public class Transport extends StatusEntity {

    @Column(name = "PLATE_NUMBER")
    private String plateNumber;

    @ManyToOne
    @JoinColumn(name = "TRANSPORT_ID", referencedColumnName = "id")
    private Route transport;

    @ManyToOne
    @JoinColumn(name = "ROUTE_ID", referencedColumnName = "id")
    private TransportRoute route;

    @ManyToOne
    @JoinColumn(name = "LGA_ID", referencedColumnName = "id")
    private Lga lga;

    @ManyToOne
    @JoinColumn(name = "PORTALUSER_ID", referencedColumnName = "id")
    private PortalUser portalUser;

    @ManyToOne
    @JoinColumn(name = "DRIVER_ID", referencedColumnName = "id")
    private TransportDriverUser driverUser;

    @ManyToOne
    @JoinColumn(name = "NIN_ID", referencedColumnName = "id")
    private NIN nin;

    @OneToOne
    @JoinColumn(name = "PAYMENT_FREQUENCY_ID", referencedColumnName = "id")
    private PaymentFrequency paymentFrequency;

    @Column(name = "PAYMENT_MODE")
    private String paymentMode;

    @Enumerated(EnumType.STRING)
    private TransportType type;

    @CreationTimestamp
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME, pattern = "yyyy-MM-dd h:m:s")
    @Column(name = "TIME_CREATED")
    private LocalDateTime timeCreated;

    @UpdateTimestamp
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME, pattern = "yyyy-MM-dd h:m:s")
    @Column(name = "TIME_UPDATED")
    private LocalDateTime timeUpdated;
}

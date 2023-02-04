package com.app.AIRS.entity;

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
@Table(name = "SHOP_OWNER")
public class ShopOwner extends StatusEntity{

    @ManyToOne
    @JoinColumn(name = "MARKET_ID", referencedColumnName = "id")
    private Markets market;

    @ManyToOne
    @JoinColumn(name = "LINE_ID", referencedColumnName = "id")
    private Lines line;

    @ManyToOne
    @JoinColumn(name = "LGA_ID", referencedColumnName = "id")
    private Lga lga;

    @ManyToOne
    @JoinColumn(name = "PORTALUSER_ID", referencedColumnName = "id")
    private PortalUser portalUser;

    @ManyToOne
    @JoinColumn(name = "NIN_ID", referencedColumnName = "id")
    private NIN nin;

    @ManyToOne
    @JoinColumn(name = "SHOP_ID", referencedColumnName = "id")
    private Shop shop;

    @ManyToOne
    @JoinColumn(name = "TIN_ID", referencedColumnName = "id")
    private Tin tin;

}

package com.app.AIRS.entity;

import com.app.AIRS.entity.userManagement.StatusEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table
@Entity(name = "SHOP")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Shop  extends StatusEntity {

    @Column(name = "SHOP_NUMBER")
    private String shop_number;

    @Column(name = "NUMBER_OF_OCCUPANT")
    private Long number_of_occupants;

    @Column(name = "PAYMENT_MODE")
    private String paymentMode;

    @ManyToOne
    @JoinColumn(name = "MARKET_ID", referencedColumnName = "id")
    private Markets market;

    @ManyToOne
    @JoinColumn(name = "LINES_ID", referencedColumnName = "id")
    private Lines line;

    @ManyToOne
    @JoinColumn(name = "TIN_ID", referencedColumnName = "id")
    private Tin tin;

}

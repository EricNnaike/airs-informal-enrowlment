package com.app.AIRS.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Data
@Entity
@Table(name = "PAYMENT_FREQUENCY")
public class PaymentFrequency {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "PERIOD", nullable = true)
    private String period;

    @Column(name = "AMOUNT", nullable = true)
    private Double amount;

}

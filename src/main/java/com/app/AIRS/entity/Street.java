package com.app.AIRS.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Streets")
public class Street {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Long lga;
    private Long area;
}

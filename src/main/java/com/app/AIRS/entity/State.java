package com.app.AIRS.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;


/**
 * @author
 */
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "STATE")
public class State implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "CODE", nullable = false)
    private String code;

    @Column(name = "LOGO", nullable = true)
    private String logo;

    @Column(name = "WEBSITE")
    private String website;

    @Column(name = "STATE_SLOGAN")
    private String stateSlogan;

    @Column(name = "ZONE_FK")
    private String zoneFk;

    @Column(name = "COUNTRY_FK")
    private String countryFk;

    public State(Long id) {
        this.id = id;
    }

}

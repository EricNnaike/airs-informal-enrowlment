package com.app.AIRS.entity;

import com.app.AIRS.Enum.Gender;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;

@Data
@Entity
@Table(name = "USER_DEMOGRAPHIC_INDIVIVUAL")
public class UserDemographicIndividual implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @OneToOne
    @JoinColumn(name = "USER_ID", referencedColumnName = "id")
    private User user;

    @Column(name = "BVN", unique = true)
    private String bvn;

    @Column(name = "FIRSTNAME")
    private String firstname;

    @Column(name = "LASTNAME")
    private String lastname;

    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;

    @Column(name = "GENDER")
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "CITY")
    private String city;

    @Column(name = "LGA_ID")
    private Long lgaId;

    @Column(name = "LEGACY")
    private Boolean legacy = false;


    @Column(name = "STATE_ID")
    private Long stateId;

    private String photo;
    private Long lga;
    private Long area;
    private String houseNumber;
    private String landMark;
    private String name;
    private String asin;
    private String dateCreated;
    private String email;
    private String middlename;

}

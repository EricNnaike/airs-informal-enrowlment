package com.app.AIRS.entity;
import lombok.Data;
import javax.persistence.*;


@Data
@Entity
@Table(name = "ROUTE")
public class Route {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
}

package com.app.AIRS.entity.lgaArea;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "LGA_AREAS")
public class LgaAreas implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ID")
  private Long id;

  @Column(name = "NAME", nullable = false) private String name;

  @Column(name = "LGA_ID") private Long lgaId;

  @Column(name = "LGA_TYPES") private Long lgaTypeId;

  @Column(name = "CODE") private String code;

  @Column(name = "STATUS") private String status;

}

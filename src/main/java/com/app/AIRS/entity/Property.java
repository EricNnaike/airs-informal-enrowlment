package com.app.AIRS.entity;


import com.app.AIRS.entity.lgaArea.LgaAreas;
import com.app.AIRS.entity.userManagement.StatusEntity;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "Property")
public class Property extends StatusEntity {
    private String houseNumber;

    @ManyToOne
    @JoinColumn(name = "BUILDING_TYPE", referencedColumnName = "id")
    private Building_type type;

    @ManyToOne
    @JoinColumn(name = "BUILDING_CATEGORY", referencedColumnName = "id")
    private Building_category category;

    private String floors;
    private String apartment;
    private String pid = "P" + LocalDate.now().getYear()+ (int)(Math.random()* 12345607);

    @ManyToOne
    @JoinColumn(name = "LGA_AREA_ID", referencedColumnName = "id")
    private LgaAreas area;

    @ManyToOne
    @JoinColumn(name = "STREET_ID", referencedColumnName = "id")
    private Street street;
}

package com.app.AIRS.entity;

import com.app.AIRS.entity.userManagement.StatusEntity;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table
@Entity(name = "BUILDING_CATEGORY")
@Data
public class Building_category extends StatusEntity {

    private String name;

    @ManyToOne
    @JoinColumn(name = "BUILDING_TYPE", referencedColumnName = "id")
    private Building_type type;
}

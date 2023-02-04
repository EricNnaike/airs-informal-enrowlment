package com.app.AIRS.entity;

import com.app.AIRS.entity.userManagement.StatusEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

@Table
@Entity(name = "BUILDING_TYPE")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Building_type extends StatusEntity {
    private String name;
}

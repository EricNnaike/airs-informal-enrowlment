package com.app.AIRS.dto;

import lombok.Data;
import java.time.LocalDate;

@Data
public class PropertyPojo {
    private String street;
    private String houseNumber;
    private String category;
    private String lga;
    private String area;
    private String type;
    private int occupants;
    private String pid;
    private String apartments;
    private LocalDate dateCreated;
}

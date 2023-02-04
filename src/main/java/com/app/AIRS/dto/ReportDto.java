package com.app.AIRS.dto;

import lombok.Data;

@Data
public class ReportDto {
    private int market;
    private int transport;
    private int property;
    private int asin;
    private String username;
    private String image;
}

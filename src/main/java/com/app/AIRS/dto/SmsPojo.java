package com.app.AIRS.dto;

import lombok.Data;
import java.time.LocalDate;

@Data
public class SmsPojo {
    private String phoneNumber;
    private String token;
    private Boolean used;
    private LocalDate createdAt;
}

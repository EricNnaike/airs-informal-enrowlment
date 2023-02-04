package com.app.AIRS.dto;


import com.app.AIRS.Enum.GenericStatusConstant;
import com.app.AIRS.entity.userManagement.Roles;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class PortalUserPojo {
    private Long id;
    private String name;
    private String email;
    private LocalDate dateCreated;
    private Roles role;
    private GenericStatusConstant status;
}
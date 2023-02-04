package com.app.AIRS.dto;

import lombok.Data;


@Data
public class PasswordDto {
    private String username;
    private String oldPassword;
    private String newPassword;
}

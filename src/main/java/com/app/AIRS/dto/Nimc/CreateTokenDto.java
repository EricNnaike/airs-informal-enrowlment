package com.app.AIRS.dto.Nimc;

import lombok.Data;

@Data
public class CreateTokenDto {
    private String username;
    private String password;
    private String orgId;
    private String token;
}

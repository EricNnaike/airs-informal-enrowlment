package com.app.AIRS.api_response;

import com.app.AIRS.Enum.PermissionTypeConstant;
import lombok.Data;

import java.util.List;

@Data
public class LoginResponse {
    private String firstName;
    private String lastName;
    private String image;
    private String token;
    private String role;
    private List<PermissionTypeConstant> permissions;
}

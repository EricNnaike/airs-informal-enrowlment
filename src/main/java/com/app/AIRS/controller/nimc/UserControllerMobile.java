package com.app.AIRS.controller.nimc;


import com.app.AIRS.api_response.LoginResponse;
import com.app.AIRS.dto.LoginRequestDto;
import com.app.AIRS.service.UserManagementService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class UserControllerMobile {
    private final UserManagementService userManagementService;

    @PostMapping("/login/mobile")
    public LoginResponse authenticateUserForMobile(@RequestBody LoginRequestDto dto) throws Exception {
        LoginResponse response = userManagementService.authenticateUser(dto);
        return response;
    }

}

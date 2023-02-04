package com.app.AIRS.configuration;


import com.app.AIRS.Enum.GenericStatusConstant;
import com.app.AIRS.Enum.PermissionTypeConstant;
import com.app.AIRS.dto.UserDto;
import com.app.AIRS.entity.userManagement.Permission;
import com.app.AIRS.entity.userManagement.PortalUser;
import com.app.AIRS.entity.userManagement.Roles;
import com.app.AIRS.repository.PortalUserRepository;
import com.app.AIRS.repository.RolesRepository;
import com.app.AIRS.service.UserManagementService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.support.TransactionTemplate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class MasterRecordsLoader {

    private final TransactionTemplate transactionTemplate;
    private final UserManagementService userManagementService;
    private final PortalUserRepository portalUserRepository;

    @EventListener(ContextRefreshedEvent.class)
    public void init() {
        log.info("STARTING...........");
        transactionTemplate.execute(tx -> {
            try {
                loadDefaults();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        });
    }

    private void loadDefaults(){

        List<PermissionTypeConstant> permissionTypeConstantList =  new ArrayList<>();
        permissionTypeConstantList.add(PermissionTypeConstant.CREATE_USER);
        permissionTypeConstantList.add(PermissionTypeConstant.UPDATE_USER);
        permissionTypeConstantList.add(PermissionTypeConstant.PRINT_CARD);

        List<PermissionTypeConstant> permissionTypeConstantList1 =  new ArrayList<>();
        permissionTypeConstantList.add(PermissionTypeConstant.DEFAULT);

        List<PermissionTypeConstant> permissionTypeConstantList2 =  new ArrayList<>();
        permissionTypeConstantList.add(PermissionTypeConstant.MANAGE_DRIVER);

        List<PermissionTypeConstant> permissionTypeConstantList3 =  new ArrayList<>();
        permissionTypeConstantList.add(PermissionTypeConstant.CREATE_MARKET);
        permissionTypeConstantList.add(PermissionTypeConstant.CREATE_TRANSPORT);
        permissionTypeConstantList.add(PermissionTypeConstant.CREATE_PROPERTY);

        Roles role = userManagementService.createRole("SUPER_ADMIN",permissionTypeConstantList);
        Roles role1 = userManagementService.createRole("GENERAL_USER",permissionTypeConstantList1);
        Roles role2 = userManagementService.createRole( "TRANSPORT_OWNER", permissionTypeConstantList2);
        Roles role3 = userManagementService.createRole( "ADMIN", permissionTypeConstantList3);

        UserDto dto = new UserDto();
        dto.setFirstName("AIRS");
        dto.setLastName("Admin");
        dto.setPhoneNumber("+2349088394985");
        dto.setEmail("airs@oasismgt.net");
        dto.setPassword("password");
        dto.setLga(74L);
        dto.setArea(290L);

        createSuperAdminUser(dto, role);

        UserDto adminDto = new UserDto();
        adminDto.setFirstName("CRO");
        adminDto.setLastName("Admin");
        adminDto.setPhoneNumber("+2349088394985");
        adminDto.setEmail("cro@oasismgt.net");
        adminDto.setPassword("password");
        adminDto.setLga(74L);
        adminDto.setArea(290L);

        createAdminUser(adminDto, role3);
    }

    private void createSuperAdminUser(UserDto dto, Roles role) {
        portalUserRepository.findByUsernameIgnoreCaseAndStatus(dto.getEmail(), GenericStatusConstant.ACTIVE)
                .orElseGet(() -> {
                    log.info("===========CREATING SUPER_ADMIN {} ============", dto.getEmail());
                    try {
                       PortalUser portalUser = userManagementService.createUser(dto, null, role);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    return null;
                });
    }

    private void createAdminUser(UserDto dto, Roles role) {
        portalUserRepository.findByUsernameIgnoreCaseAndStatus(dto.getEmail(), GenericStatusConstant.ACTIVE)
                .orElseGet(() -> {
                    log.info("===========CREATING ADMIN {} ============", dto.getEmail());
                    try {
                        PortalUser portalUser = userManagementService.createUser(dto, null, role);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    return null;
                });
    }
}

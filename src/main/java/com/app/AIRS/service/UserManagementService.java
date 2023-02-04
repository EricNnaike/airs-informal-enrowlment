package com.app.AIRS.service;

import com.app.AIRS.Enum.PermissionTypeConstant;
import com.app.AIRS.api_response.LoginResponse;
import com.app.AIRS.dto.*;
import com.app.AIRS.entity.Building_category;
import com.app.AIRS.entity.Building_type;
import com.app.AIRS.entity.Lga;
import com.app.AIRS.entity.Street;
import com.app.AIRS.entity.lgaArea.LgaAreas;
import com.app.AIRS.entity.userManagement.PortalUser;
import com.app.AIRS.entity.userManagement.Roles;

import java.util.List;

/**
 * @author uhuegbulem chinomso
 * email: chimaisaac60@gmail.com
 * Oct, 2022
 **/

public interface UserManagementService {

    PortalUser createUser(UserDto user, PortalUser createdBy, Roles role);

    void deactivateUser(Long userId);

    void activateUser(Long userId);

    LoginResponse authenticateUser(LoginRequestDto dto) throws Exception;

    Roles createRole(String name, List<PermissionTypeConstant> permissionTypeConstants);

    PortalUserPojo get(PortalUser user);

    List<PortalUserPojo> get(List<PortalUser> users);

    List<String> getRoles();

    List<Lga> getLGAs();

    List<LgaAreas> getAreas(Long id);

    List<Street> getStreet(Long id);

    List<Building_type> getBuildingTypes();

    List<Building_category> getBuildingCategories(Long id);

    void resetPassword(PasswordDto dto) throws Exception;

    ValidationPojo validateAsin(String asin);
}

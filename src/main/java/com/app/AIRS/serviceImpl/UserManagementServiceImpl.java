package com.app.AIRS.serviceImpl;

import com.app.AIRS.dto.*;
import com.app.AIRS.entity.*;
import com.app.AIRS.entity.lgaArea.LgaAreas;
import com.app.AIRS.entity.userManagement.Roles;
import com.app.AIRS.Enum.GenericStatusConstant;
import com.app.AIRS.Enum.PermissionTypeConstant;
import com.app.AIRS.api_response.LoginResponse;
import com.app.AIRS.entity.userManagement.Permission;
import com.app.AIRS.entity.userManagement.PortalUser;
import com.app.AIRS.repository.*;
import com.app.AIRS.security.JwtService;
import com.app.AIRS.security.PasswordService;
import com.app.AIRS.service.UserManagementService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class UserManagementServiceImpl implements UserManagementService {

    private final PortalUserRepository portalUserRepository;
    private final PermissionRepository permissionRepository;
    private final RolesRepository rolesRepository;
    private final JwtService jwtService;
    private final LgaRepository lgaRepository;
    private final LgaAreaRepository lgaAreaRepository;
    private final PasswordService passwordService;
    private final StreetRepository streetRepository;
    private final BuildingTypeRepository buildingTypeRepository;
    private final BuildingCategoryRepository buildingCategoryRepository;
    private final TinRepository tinRepository;

    @Override
    @Transactional
    public PortalUser createUser(UserDto user, PortalUser createdBy, Roles role) {
        PortalUser portalUser = new PortalUser();
        portalUser.setCreatedAt(LocalDateTime.now());
        portalUser.setEmail(user.getEmail());
        portalUser.setFirstName(user.getFirstName());
        portalUser.setLastName(user.getLastName());
        portalUser.setDisplayName(String.format("%s %s", user.getFirstName(), user.getLastName()));
        portalUser.setUsername(user.getEmail());
        portalUser.setStatus(GenericStatusConstant.ACTIVE);
        portalUser.setPhoneNumber(user.getPhoneNumber());
        portalUser.setNationalIdentificationNumber(user.getNin());
        portalUser.setGeneratedPassword(passwordService.hashPassword(user.getPassword()));
        portalUser.setImage(user.getPhoto());
        portalUser.setAddress(user.getAddress());
        portalUser.setLga(lgaRepository.findById(user.getLga()).orElseThrow(RuntimeException::new));
//        portalUser.setArea(lgaAreaRepository.findById(user.getArea()).orElseThrow(RuntimeException::new));
        portalUser.setRole(role);

        portalUserRepository.save(portalUser);
        return portalUser;
    }

    @Override
    @Transactional
    public void deactivateUser(Long userId) {
        PortalUser portalUser = portalUserRepository.findByIdAndStatus(userId, GenericStatusConstant.ACTIVE).get();
        LocalDateTime now = LocalDateTime.now();

        portalUser.setStatus(GenericStatusConstant.INACTIVE);
        portalUser.setLastUpdatedAt(now);
        portalUserRepository.save(portalUser);
    }

    @Override
    @Transactional
    public void activateUser(Long userId) {
        PortalUser portalUser = portalUserRepository.findByIdAndStatus(userId, GenericStatusConstant.INACTIVE).get();
        LocalDateTime now = LocalDateTime.now();

        portalUser.setStatus(GenericStatusConstant.ACTIVE);
        portalUser.setLastUpdatedAt(now);
        portalUserRepository.save(portalUser);
    }

    @Override
    public LoginResponse authenticateUser(LoginRequestDto dto) throws Exception {

        PortalUser user = portalUserRepository.findByUsernameIgnoreCaseAndStatus(dto.getUsername(), GenericStatusConstant.ACTIVE)
                .orElseThrow(() -> new Exception("Invalid Username - " + dto.getUsername()));

       if (passwordService.comparePassword(user.getGeneratedPassword(), dto.getPassword())){
           String token = jwtService.generateJwtToken(user.getId());
           LoginResponse loginResponse = new LoginResponse();
           loginResponse.setFirstName(user.getFirstName());
           loginResponse.setLastName(user.getLastName());
           loginResponse.setImage(user.getImage());
           loginResponse.setToken(token);
           loginResponse.setRole(user.getRole().getName());
           loginResponse.setPermissions(getPermission(user.getRole()));

           return loginResponse;
       } else throw new Exception("Invalid Password");
    }

    @Override
    @Transactional
    public Roles createRole(String name, List<PermissionTypeConstant> permissionTypeConstants) {
        return rolesRepository.findByNameIgnoreCase(name).orElseGet(() -> {
            Roles newRole = new Roles();
            newRole.setName(name);
            rolesRepository.save(newRole);
            createPermission(permissionTypeConstants, newRole);
            return newRole;
        });
    }

    @Override
    public PortalUserPojo get(PortalUser user) {
        PortalUserPojo pojo = new PortalUserPojo();
        pojo.setName(user.getDisplayName());
        pojo.setEmail(user.getEmail());
        pojo.setDateCreated(user.getCreatedAt().toLocalDate());
        pojo.setRole(user.getRole());
        pojo.setStatus(user.getStatus());
        pojo.setId(user.getId());

        return pojo;
    }

    @Override
    public List<PortalUserPojo> get(List<PortalUser> users) {
        return users.stream().map(user -> {

            PortalUserPojo pojo = new PortalUserPojo();
            pojo.setName(user.getDisplayName());
            pojo.setEmail(user.getEmail());
            pojo.setDateCreated(user.getCreatedAt().toLocalDate());
            pojo.setRole(user.getRole());
            pojo.setStatus(user.getStatus());
            pojo.setId(user.getId());

            return pojo;
        }).collect(Collectors.toList());
    }

    @Override
    public List<String> getRoles() {
        List<Roles> roles = rolesRepository.findAll();
        return roles.stream().map(Roles::getName).collect(Collectors.toList());
    }

    @Override
    public List<Lga> getLGAs() {
        return lgaRepository.findAll();
    }

    @Override
    public List<LgaAreas> getAreas(Long id) {
        return lgaAreaRepository.findByLgaId(id);
    }

    @Override
    public List<Street> getStreet(Long id) {
        return streetRepository.findByArea(id);
    }

    @Override
    public List<Building_type> getBuildingTypes() {
        return buildingTypeRepository.findAll();
    }

    @Override
    public List<Building_category> getBuildingCategories(Long id) {
        return buildingCategoryRepository.findAllByType(id);
    }

    @Override
    public void resetPassword(PasswordDto dto) throws Exception {
        PortalUser user = portalUserRepository.findByUsernameIgnoreCaseAndStatus(dto.getUsername(), GenericStatusConstant.ACTIVE)
                .orElseThrow(() -> new Exception("Invalid Username - " + dto.getUsername()));

        if (passwordService.comparePassword(user.getGeneratedPassword(), dto.getOldPassword())){
           user.setGeneratedPassword(passwordService.hashPassword(dto.getNewPassword()));
           user.setLastUpdatedAt(LocalDateTime.now());
           portalUserRepository.save(user);
        } else throw new Exception("Invalid Password");
    }

    @Override
    public ValidationPojo validateAsin(String asin) {
        Tin tin = tinRepository.findFirstByTinNumber(asin);
        if (tin != null){
            ValidationPojo pojo = new ValidationPojo();
            pojo.setFirstName(tin.getPortalUser().getFirstName());
            pojo.setLastName(tin.getPortalUser().getLastName());
            pojo.setPhoneNumber(tin.getPortalUser().getPhoneNumber());

            return pojo;
        }
        return null;
    }


    private void createPermission(List<PermissionTypeConstant> permissionTypeConstants, Roles role) {
        permissionTypeConstants.forEach(permissionTypeConstant -> {
            Permission permission = new Permission();
            permission.setPermissionTypeConstant(permissionTypeConstant);
            permission.setRole(role);
            permissionRepository.save(permission);
        });
    }

    private List<PermissionTypeConstant> getPermission(Roles role){
        List<Permission> permissions = permissionRepository.findAllByRole(role);

        List<PermissionTypeConstant> permissionTypeConstantList = new ArrayList<>();

        permissions.forEach(permission -> {
            permissionTypeConstantList.add(permission.getPermissionTypeConstant());
        });

        return permissionTypeConstantList;
    }
}

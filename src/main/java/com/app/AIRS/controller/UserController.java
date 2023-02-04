package com.app.AIRS.controller;


import com.app.AIRS.Utils.PredicateExtractor;
import com.app.AIRS.api_response.LoginResponse;
import com.app.AIRS.dto.*;
import com.app.AIRS.dto.filters.PortalUserSearchFilter;
import com.app.AIRS.entity.Building_category;
import com.app.AIRS.entity.Building_type;
import com.app.AIRS.entity.Lga;
import com.app.AIRS.entity.Street;
import com.app.AIRS.entity.lgaArea.LgaAreas;
import com.app.AIRS.entity.userManagement.PortalUser;
import com.app.AIRS.entity.userManagement.QPortalUser;
import com.app.AIRS.entity.userManagement.Roles;
import com.app.AIRS.repository.RolesRepository;
import com.app.AIRS.repository.app.AppRepository;
import com.app.AIRS.security.JwtService;
import com.app.AIRS.service.UserManagementService;
import com.querydsl.core.QueryResults;
import com.querydsl.core.types.Order;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.jpa.impl.JPAQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.time.LocalTime;
import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class UserController {

    private final UserManagementService userManagementService;
    private final RolesRepository rolesRepository;
    private final AppRepository appRepository;
    private final PredicateExtractor predicateExtractor;
    private final JwtService jwtService;


    @GetMapping("/search")
    @Transactional
    public QueryResults<PortalUserPojo> searchUsers(PortalUserSearchFilter filter){

        JPAQuery<PortalUser> portalUserJPAQuery = appRepository.startJPAQuery(QPortalUser.portalUser)
                .where(predicateExtractor.getPredicate(filter))
                .offset(filter.getOffset().orElse(0))
                .limit(filter.getLimit().orElse(10));

        if (filter.getCreatedAfter() != null){
            portalUserJPAQuery.where(QPortalUser.portalUser.createdAt.goe(filter.getCreatedAfter().atStartOfDay()));
        }

        if (filter.getCreatedBefore() != null){
            portalUserJPAQuery.where(QPortalUser.portalUser.createdAt.loe(filter.getCreatedBefore().atTime(LocalTime.MAX)));
        }

        OrderSpecifier<?> sortedColumn = appRepository.getSortedColumn(filter.getOrder().orElse(Order.DESC), filter.getOrderColumn().orElse("createdAt"), QPortalUser.portalUser);
        QueryResults<PortalUser> portalUserQueryResults = portalUserJPAQuery.select(QPortalUser.portalUser).distinct().orderBy(sortedColumn).fetchResults();
        return new QueryResults<>(userManagementService.get(portalUserQueryResults.getResults()), portalUserQueryResults.getLimit(), portalUserQueryResults.getOffset(), portalUserQueryResults.getTotal());
    }
    
    @PostMapping("/login")
    public ResponseEntity<LoginResponse> authenticateUser(@RequestBody LoginRequestDto dto) throws Exception {
        LoginResponse response = userManagementService.authenticateUser(dto);
        return ResponseEntity.ok(response);

    }
    @PostMapping("/create")
    public PortalUserPojo createUser(@RequestBody @Valid UserDto dto) {
        Roles role = rolesRepository.findByNameIgnoreCase(dto.getRole()).orElseThrow(RuntimeException::new);
        return userManagementService.get(userManagementService.createUser(dto, jwtService.user, role));
    }

    @PostMapping("/deactivate")
    public HttpStatus deactivateUser(@RequestParam Long userId) {
        userManagementService.deactivateUser(userId);
        return HttpStatus.OK;
    }

    @PostMapping("/activate")
    public HttpStatus activateUser(@RequestParam Long userId) {
        userManagementService.activateUser(userId);
        return HttpStatus.OK;
    }

    @PostMapping("/reset-password")
    public HttpStatus resetPassword(@RequestBody PasswordDto dto) throws Exception {
        userManagementService.resetPassword(dto);
        return HttpStatus.OK;
    }

    @GetMapping("/roles")
    public List<String> getRoles(){
        return userManagementService.getRoles();
    }

    @GetMapping("/lga")
    public List<Lga> getLGAs(){
        return userManagementService.getLGAs();
    }

    @GetMapping("/area")
    public List<LgaAreas> getAreas(@RequestParam Long id){
        return userManagementService.getAreas(id);
    }

    @GetMapping("/streets")
    public List<Street> getStreet(@RequestParam Long id){
        return userManagementService.getStreet(id);
    }

    @GetMapping("/building-types")
    public List<Building_type> getBuildingTypes(){
        return userManagementService.getBuildingTypes();
    }

    @GetMapping("/building-categories")
    public List<Building_category> getBuildingCategories(@RequestParam Long id){
        return userManagementService.getBuildingCategories(id);
    }

    @GetMapping("/validate/{asin}")
    public ValidationPojo validateAsin(@PathVariable("asin") String asin){
        return userManagementService.validateAsin(asin);
    }

}

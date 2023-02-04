package com.app.AIRS.repository;


import com.app.AIRS.entity.userManagement.Permission;
import com.app.AIRS.entity.userManagement.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PermissionRepository extends JpaRepository<Permission, Long> {

    List<Permission> findAllByRole(Roles role);
}

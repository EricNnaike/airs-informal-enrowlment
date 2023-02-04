package com.app.AIRS.repository;

import com.app.AIRS.entity.userManagement.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface RolesRepository extends JpaRepository<Roles, Long> {

    Optional<Roles> findByNameIgnoreCase(String name);
}

package com.app.AIRS.repository;

import com.app.AIRS.Enum.GenericStatusConstant;
import com.app.AIRS.entity.userManagement.PortalUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PortalUserRepository extends JpaRepository<PortalUser, Long> {
    Optional<PortalUser> findByUsernameIgnoreCaseAndStatus(String username, GenericStatusConstant status);

    Optional<PortalUser> findByIdAndStatus(Long id,GenericStatusConstant status );

    PortalUser findByUsernameIgnoreCase(String email);

    PortalUser findFirstByUsernameIgnoreCase(String email);

    PortalUser findByPhoneNumber(String number);

    PortalUser findFirstByPhoneNumber(String number);
}

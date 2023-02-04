package com.app.AIRS.repository;

import com.app.AIRS.entity.NIN;
import com.app.AIRS.entity.User;
import com.app.AIRS.entity.userManagement.PortalUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    User findFirstByNin(NIN nin);

    List<User> findAllByCreatedBy(PortalUser user);
}

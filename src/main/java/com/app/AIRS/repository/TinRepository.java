package com.app.AIRS.repository;

import com.app.AIRS.Enum.TinType;
import com.app.AIRS.entity.Tin;
import com.app.AIRS.entity.User;
import com.app.AIRS.entity.userManagement.PortalUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TinRepository extends JpaRepository<Tin, Long> {
    Tin findFirstByTinNumber(String tinNumber);

    boolean existsByTinNumber(String tinNumber);

    Tin findFirstByPortalUserAndTinType(PortalUser portalUser, TinType tinType);

    Tin findFirstByPortalUser(PortalUser portalUser);

}

package com.app.AIRS.repository;

import com.app.AIRS.entity.Transport;
import com.app.AIRS.entity.User;
import com.app.AIRS.entity.userManagement.PortalUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransportRepository extends JpaRepository<Transport, Long> {
    List<Transport> findAllByCreatedBy(PortalUser user);
}

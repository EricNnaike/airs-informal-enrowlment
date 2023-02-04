package com.app.AIRS.repository;

import com.app.AIRS.entity.Property;
import com.app.AIRS.entity.Street;
import com.app.AIRS.entity.userManagement.PortalUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PropertyRepository extends JpaRepository<Property, Long> {

    List<Property> findAllByCreatedBy(PortalUser user);

    List<Property> findAllByStreet(Street street);
}

package com.app.AIRS.repository;

import com.app.AIRS.entity.User;
import com.app.AIRS.entity.UserDemographicCorporate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDemographyCorperateRepository extends JpaRepository<UserDemographicCorporate, Long> {
    UserDemographicCorporate findFirstByUser(User user);
}

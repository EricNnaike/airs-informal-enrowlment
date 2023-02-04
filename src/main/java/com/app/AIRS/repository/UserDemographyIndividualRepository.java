package com.app.AIRS.repository;

import com.app.AIRS.entity.User;
import com.app.AIRS.entity.UserDemographicIndividual;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserDemographyIndividualRepository extends JpaRepository<UserDemographicIndividual, Long> {

    List<UserDemographicIndividual> findFirstByUser(User user);
}

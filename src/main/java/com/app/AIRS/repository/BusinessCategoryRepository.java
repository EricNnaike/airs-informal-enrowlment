package com.app.AIRS.repository;

import com.app.AIRS.entity.Building_category;
import com.app.AIRS.entity.BusinessClassification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BusinessCategoryRepository extends JpaRepository<BusinessClassification, Long> {

    @Query(value="SELECT * FROM BUSINESS_CLASSIFICATION  where nature_of_busiess_fk = :id  ORDER BY id DESC", nativeQuery = true) //Todo include where clause CHANGE HARDCODED MSG
    List<BusinessClassification> findByNatureOfBusiessFk(Long id);
}

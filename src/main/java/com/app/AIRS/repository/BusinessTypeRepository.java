package com.app.AIRS.repository;

import com.app.AIRS.entity.Building_type;
import com.app.AIRS.entity.BusinessType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BusinessTypeRepository extends JpaRepository<BusinessType, Long> {

}

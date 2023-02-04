package com.app.AIRS.repository;

import com.app.AIRS.entity.TransportDriverUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransportDriverRepository extends JpaRepository<TransportDriverUser, Long> {
}

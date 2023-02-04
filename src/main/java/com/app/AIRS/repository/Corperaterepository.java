package com.app.AIRS.repository;

import com.app.AIRS.entity.Corperate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Corperaterepository extends JpaRepository<Corperate, Long> {
    Corperate findFirstByEmail(String email);
}

package com.app.AIRS.repository;

import com.app.AIRS.entity.NIN;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NinRepository extends JpaRepository<NIN, Long> {
    NIN findByNin(String nin);

    NIN findByTelePhoneNumber(String phoneNumber);
}

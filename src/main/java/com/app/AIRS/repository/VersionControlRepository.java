package com.app.AIRS.repository;

import com.app.AIRS.Utils.OkHttpUtil;
import com.app.AIRS.entity.VersionControl;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VersionControlRepository extends JpaRepository<VersionControl, Long> {
    VersionControl findFirstById(long l);
}

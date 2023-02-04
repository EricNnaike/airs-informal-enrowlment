package com.app.AIRS.repository;
import com.app.AIRS.entity.Lines;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LineRepository extends JpaRepository<Lines, Long> {

    @Query(value="SELECT * FROM LINES where market_id = :id", nativeQuery = true)
    List<Lines> findAllByMarket(Long id);
}

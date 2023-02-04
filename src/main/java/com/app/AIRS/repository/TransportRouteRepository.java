package com.app.AIRS.repository;

import com.app.AIRS.entity.TransportRoute;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TransportRouteRepository extends JpaRepository<TransportRoute, Long> {

    @Query(value="SELECT * FROM TRANSPORT_ROUTE where ROUTE_ID = :id", nativeQuery = true)
    List<TransportRoute> findByTransport(Long id);
}

package com.app.AIRS.repository;

import com.app.AIRS.entity.Lines;
import com.app.AIRS.entity.Shop;
import com.app.AIRS.entity.ShopOwner;
import com.app.AIRS.entity.userManagement.PortalUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ShopRepository extends JpaRepository<Shop, Long> {

    @Query(value="SELECT * FROM SHOP WHERE shop_number = :shop_number AND lines_id=:line", nativeQuery = true)
    Shop findByShop_NumberAndLine(String shop_number, Lines line);

    @Query(value="SELECT * FROM SHOP WHERE shop_number = :id", nativeQuery = true)
    Shop findFirstByShopNumber(String id);
}

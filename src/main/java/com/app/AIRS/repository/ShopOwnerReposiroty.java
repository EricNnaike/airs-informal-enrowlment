package com.app.AIRS.repository;

import com.app.AIRS.entity.Lines;
import com.app.AIRS.entity.NIN;
import com.app.AIRS.entity.Shop;
import com.app.AIRS.entity.ShopOwner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ShopOwnerReposiroty extends JpaRepository<ShopOwner, Long> {

    List<ShopOwner> findByShop(Shop shop);


    @Query(value="SELECT * FROM SHOP_OWNER WHERE LINE_ID = :lines AND NIN_ID=:nin AND SHOP_ID=:shop1", nativeQuery = true)
    ShopOwner findByLineIdNinIdShopId(Lines lines, NIN nin, Shop shop1);
}

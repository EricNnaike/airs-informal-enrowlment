package com.app.AIRS.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QShopOwner is a Querydsl query type for ShopOwner
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QShopOwner extends EntityPathBase<ShopOwner> {

    private static final long serialVersionUID = -164001379L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QShopOwner shopOwner = new QShopOwner("shopOwner");

    public final com.app.AIRS.entity.userManagement.QStatusEntity _super;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt;

    // inherited
    public final com.app.AIRS.entity.userManagement.QPortalUser createdBy;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> dateDeactivated;

    // inherited
    public final com.app.AIRS.entity.userManagement.QPortalUser deactivatedBy;

    //inherited
    public final NumberPath<Long> id;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> lastUpdatedAt;

    public final QLga lga;

    public final QLines line;

    public final QMarkets market;

    public final QNIN nin;

    public final com.app.AIRS.entity.userManagement.QPortalUser portalUser;

    public final QShop shop;

    //inherited
    public final EnumPath<com.app.AIRS.Enum.GenericStatusConstant> status;

    public final QTin tin;

    public QShopOwner(String variable) {
        this(ShopOwner.class, forVariable(variable), INITS);
    }

    public QShopOwner(Path<? extends ShopOwner> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QShopOwner(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QShopOwner(PathMetadata metadata, PathInits inits) {
        this(ShopOwner.class, metadata, inits);
    }

    public QShopOwner(Class<? extends ShopOwner> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this._super = new com.app.AIRS.entity.userManagement.QStatusEntity(type, metadata, inits);
        this.createdAt = _super.createdAt;
        this.createdBy = _super.createdBy;
        this.dateDeactivated = _super.dateDeactivated;
        this.deactivatedBy = _super.deactivatedBy;
        this.id = _super.id;
        this.lastUpdatedAt = _super.lastUpdatedAt;
        this.lga = inits.isInitialized("lga") ? new QLga(forProperty("lga")) : null;
        this.line = inits.isInitialized("line") ? new QLines(forProperty("line"), inits.get("line")) : null;
        this.market = inits.isInitialized("market") ? new QMarkets(forProperty("market"), inits.get("market")) : null;
        this.nin = inits.isInitialized("nin") ? new QNIN(forProperty("nin")) : null;
        this.portalUser = inits.isInitialized("portalUser") ? new com.app.AIRS.entity.userManagement.QPortalUser(forProperty("portalUser"), inits.get("portalUser")) : null;
        this.shop = inits.isInitialized("shop") ? new QShop(forProperty("shop"), inits.get("shop")) : null;
        this.status = _super.status;
        this.tin = inits.isInitialized("tin") ? new QTin(forProperty("tin"), inits.get("tin")) : null;
    }

}


package com.app.AIRS.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMarketUser is a Querydsl query type for ShopOwner
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMarketUser extends EntityPathBase<ShopOwner> {

    private static final long serialVersionUID = 1574536679L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMarketUser marketUser = new QMarketUser("marketUser");

    public final StringPath address = createString("address");

    public final StringPath asin = createString("asin");

    public final StringPath firstName = createString("firstName");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath lastName = createString("lastName");

    public final QLga lga;

    public final QLines line;

    public final QMarkets market;

    public final StringPath nin = createString("nin");

    public final StringPath otherName = createString("otherName");

    public final QPaymentFrequency paymentFrequency;

    public final StringPath paymentMode = createString("paymentMode");

    public final StringPath phonenumber = createString("phonenumber");

    public final StringPath photo = createString("photo");

    public final StringPath shopNumber = createString("shopNumber");

    public final DateTimePath<java.time.LocalDateTime> timeCreated = createDateTime("timeCreated", java.time.LocalDateTime.class);

    public final DateTimePath<java.time.LocalDateTime> timeUpdated = createDateTime("timeUpdated", java.time.LocalDateTime.class);

    public final QUser user;

    public final QUserGroup userGroup;

    public QMarketUser(String variable) {
        this(ShopOwner.class, forVariable(variable), INITS);
    }

    public QMarketUser(Path<? extends ShopOwner> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMarketUser(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMarketUser(PathMetadata metadata, PathInits inits) {
        this(ShopOwner.class, metadata, inits);
    }

    public QMarketUser(Class<? extends ShopOwner> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.lga = inits.isInitialized("lga") ? new QLga(forProperty("lga")) : null;
        this.line = inits.isInitialized("line") ? new QLines(forProperty("line"), inits.get("line")) : null;
        this.market = inits.isInitialized("market") ? new QMarkets(forProperty("market"), inits.get("market")) : null;
        this.paymentFrequency = inits.isInitialized("paymentFrequency") ? new QPaymentFrequency(forProperty("paymentFrequency")) : null;
        this.user = inits.isInitialized("user") ? new QUser(forProperty("user")) : null;
        this.userGroup = inits.isInitialized("userGroup") ? new QUserGroup(forProperty("userGroup")) : null;
    }

}


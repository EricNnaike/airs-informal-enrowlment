package com.app.AIRS.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QTransportUser is a Querydsl query type for Transport
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QTransportUser extends EntityPathBase<Transport> {

    private static final long serialVersionUID = 1092711124L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QTransportUser transportUser = new QTransportUser("transportUser");

    public final StringPath address = createString("address");

    public final StringPath asin = createString("asin");

    public final StringPath firstName = createString("firstName");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath lastName = createString("lastName");

    public final QLga lga;

    public final StringPath nin = createString("nin");

    public final StringPath otherName = createString("otherName");

    public final QPaymentFrequency paymentFrequency;

    public final StringPath paymentMode = createString("paymentMode");

    public final StringPath phonenumber = createString("phonenumber");

    public final StringPath photo = createString("photo");

    public final StringPath plateNumber = createString("plateNumber");

    public final QTransportRoute route;

    public final DateTimePath<java.time.LocalDateTime> timeCreated = createDateTime("timeCreated", java.time.LocalDateTime.class);

    public final DateTimePath<java.time.LocalDateTime> timeUpdated = createDateTime("timeUpdated", java.time.LocalDateTime.class);

    public final QRoute transport;

    public final QUser user;

    public final QUserGroup userGroup;

    public QTransportUser(String variable) {
        this(Transport.class, forVariable(variable), INITS);
    }

    public QTransportUser(Path<? extends Transport> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QTransportUser(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QTransportUser(PathMetadata metadata, PathInits inits) {
        this(Transport.class, metadata, inits);
    }

    public QTransportUser(Class<? extends Transport> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.lga = inits.isInitialized("lga") ? new QLga(forProperty("lga")) : null;
        this.paymentFrequency = inits.isInitialized("paymentFrequency") ? new QPaymentFrequency(forProperty("paymentFrequency")) : null;
        this.route = inits.isInitialized("route") ? new QTransportRoute(forProperty("route"), inits.get("route")) : null;
        this.transport = inits.isInitialized("transport") ? new QRoute(forProperty("transport")) : null;
        this.user = inits.isInitialized("user") ? new QUser(forProperty("user")) : null;
        this.userGroup = inits.isInitialized("userGroup") ? new QUserGroup(forProperty("userGroup")) : null;
    }

}


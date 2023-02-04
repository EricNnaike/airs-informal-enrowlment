package com.app.AIRS.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QTransport is a Querydsl query type for Transport
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QTransport extends EntityPathBase<Transport> {

    private static final long serialVersionUID = -1287590039L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QTransport transport1 = new QTransport("transport1");

    public final com.app.AIRS.entity.userManagement.QStatusEntity _super;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt;

    // inherited
    public final com.app.AIRS.entity.userManagement.QPortalUser createdBy;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> dateDeactivated;

    // inherited
    public final com.app.AIRS.entity.userManagement.QPortalUser deactivatedBy;

    public final QTransportDriverUser driverUser;

    //inherited
    public final NumberPath<Long> id;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> lastUpdatedAt;

    public final QLga lga;

    public final QNIN nin;

    public final QPaymentFrequency paymentFrequency;

    public final StringPath paymentMode = createString("paymentMode");

    public final StringPath plateNumber = createString("plateNumber");

    public final com.app.AIRS.entity.userManagement.QPortalUser portalUser;

    public final QTransportRoute route;

    //inherited
    public final EnumPath<com.app.AIRS.Enum.GenericStatusConstant> status;

    public final DateTimePath<java.time.LocalDateTime> timeCreated = createDateTime("timeCreated", java.time.LocalDateTime.class);

    public final DateTimePath<java.time.LocalDateTime> timeUpdated = createDateTime("timeUpdated", java.time.LocalDateTime.class);

    public final QRoute transport;

    public final EnumPath<com.app.AIRS.Enum.TransportType> type = createEnum("type", com.app.AIRS.Enum.TransportType.class);

    public QTransport(String variable) {
        this(Transport.class, forVariable(variable), INITS);
    }

    public QTransport(Path<? extends Transport> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QTransport(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QTransport(PathMetadata metadata, PathInits inits) {
        this(Transport.class, metadata, inits);
    }

    public QTransport(Class<? extends Transport> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this._super = new com.app.AIRS.entity.userManagement.QStatusEntity(type, metadata, inits);
        this.createdAt = _super.createdAt;
        this.createdBy = _super.createdBy;
        this.dateDeactivated = _super.dateDeactivated;
        this.deactivatedBy = _super.deactivatedBy;
        this.driverUser = inits.isInitialized("driverUser") ? new QTransportDriverUser(forProperty("driverUser"), inits.get("driverUser")) : null;
        this.id = _super.id;
        this.lastUpdatedAt = _super.lastUpdatedAt;
        this.lga = inits.isInitialized("lga") ? new QLga(forProperty("lga")) : null;
        this.nin = inits.isInitialized("nin") ? new QNIN(forProperty("nin")) : null;
        this.paymentFrequency = inits.isInitialized("paymentFrequency") ? new QPaymentFrequency(forProperty("paymentFrequency")) : null;
        this.portalUser = inits.isInitialized("portalUser") ? new com.app.AIRS.entity.userManagement.QPortalUser(forProperty("portalUser"), inits.get("portalUser")) : null;
        this.route = inits.isInitialized("route") ? new QTransportRoute(forProperty("route"), inits.get("route")) : null;
        this.status = _super.status;
        this.transport = inits.isInitialized("transport") ? new QRoute(forProperty("transport")) : null;
    }

}


package com.app.AIRS.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QTransportDriverUser is a Querydsl query type for TransportDriverUser
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QTransportDriverUser extends EntityPathBase<TransportDriverUser> {

    private static final long serialVersionUID = -768737188L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QTransportDriverUser transportDriverUser = new QTransportDriverUser("transportDriverUser");

    public final com.app.AIRS.entity.userManagement.QStatusEntity _super;

    public final StringPath address = createString("address");

    public final StringPath asin = createString("asin");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt;

    // inherited
    public final com.app.AIRS.entity.userManagement.QPortalUser createdBy;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> dateDeactivated;

    // inherited
    public final com.app.AIRS.entity.userManagement.QPortalUser deactivatedBy;

    public final StringPath email = createString("email");

    public final StringPath firstName = createString("firstName");

    //inherited
    public final NumberPath<Long> id;

    public final StringPath lastName = createString("lastName");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> lastUpdatedAt;

    public final StringPath name = createString("name");

    public final QNIN nin;

    public final StringPath otherName = createString("otherName");

    public final QTransport owner;

    public final StringPath phonenumber = createString("phonenumber");

    public final StringPath photo = createString("photo");

    //inherited
    public final EnumPath<com.app.AIRS.Enum.GenericStatusConstant> status;

    public final DateTimePath<java.time.LocalDateTime> timeCreated = createDateTime("timeCreated", java.time.LocalDateTime.class);

    public final DateTimePath<java.time.LocalDateTime> timeUpdated = createDateTime("timeUpdated", java.time.LocalDateTime.class);

    public QTransportDriverUser(String variable) {
        this(TransportDriverUser.class, forVariable(variable), INITS);
    }

    public QTransportDriverUser(Path<? extends TransportDriverUser> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QTransportDriverUser(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QTransportDriverUser(PathMetadata metadata, PathInits inits) {
        this(TransportDriverUser.class, metadata, inits);
    }

    public QTransportDriverUser(Class<? extends TransportDriverUser> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this._super = new com.app.AIRS.entity.userManagement.QStatusEntity(type, metadata, inits);
        this.createdAt = _super.createdAt;
        this.createdBy = _super.createdBy;
        this.dateDeactivated = _super.dateDeactivated;
        this.deactivatedBy = _super.deactivatedBy;
        this.id = _super.id;
        this.lastUpdatedAt = _super.lastUpdatedAt;
        this.nin = inits.isInitialized("nin") ? new QNIN(forProperty("nin")) : null;
        this.owner = inits.isInitialized("owner") ? new QTransport(forProperty("owner"), inits.get("owner")) : null;
        this.status = _super.status;
    }

}


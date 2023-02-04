package com.app.AIRS.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QUser is a Querydsl query type for User
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QUser extends EntityPathBase<User> {

    private static final long serialVersionUID = -1502688373L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QUser user = new QUser("user");

    public final com.app.AIRS.entity.userManagement.QStatusEntity _super;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt;

    // inherited
    public final com.app.AIRS.entity.userManagement.QPortalUser createdBy;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> dateDeactivated;

    // inherited
    public final com.app.AIRS.entity.userManagement.QPortalUser deactivatedBy;

    public final StringPath houseNumber = createString("houseNumber");

    //inherited
    public final NumberPath<Long> id;

    public final StringPath landmark = createString("landmark");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> lastUpdatedAt;

    public final QNIN nin;

    public final com.app.AIRS.entity.userManagement.QPortalUser portalUser;

    //inherited
    public final EnumPath<com.app.AIRS.Enum.GenericStatusConstant> status;

    public final StringPath streetname = createString("streetname");

    public final DateTimePath<java.time.LocalDateTime> timeCreated = createDateTime("timeCreated", java.time.LocalDateTime.class);

    public final DateTimePath<java.time.LocalDateTime> timeUpdated = createDateTime("timeUpdated", java.time.LocalDateTime.class);

    public QUser(String variable) {
        this(User.class, forVariable(variable), INITS);
    }

    public QUser(Path<? extends User> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QUser(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QUser(PathMetadata metadata, PathInits inits) {
        this(User.class, metadata, inits);
    }

    public QUser(Class<? extends User> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this._super = new com.app.AIRS.entity.userManagement.QStatusEntity(type, metadata, inits);
        this.createdAt = _super.createdAt;
        this.createdBy = _super.createdBy;
        this.dateDeactivated = _super.dateDeactivated;
        this.deactivatedBy = _super.deactivatedBy;
        this.id = _super.id;
        this.lastUpdatedAt = _super.lastUpdatedAt;
        this.nin = inits.isInitialized("nin") ? new QNIN(forProperty("nin")) : null;
        this.portalUser = inits.isInitialized("portalUser") ? new com.app.AIRS.entity.userManagement.QPortalUser(forProperty("portalUser"), inits.get("portalUser")) : null;
        this.status = _super.status;
    }

}


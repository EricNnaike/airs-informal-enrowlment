package com.app.AIRS.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QIdentity is a Querydsl query type for Identity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QIdentity extends EntityPathBase<Identity> {

    private static final long serialVersionUID = -72716162L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QIdentity identity = new QIdentity("identity");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final com.app.AIRS.entity.userManagement.QPortalUser portalUser;

    public final DateTimePath<java.time.LocalDateTime> timeCreated = createDateTime("timeCreated", java.time.LocalDateTime.class);

    public final DateTimePath<java.time.LocalDateTime> timeUpdated = createDateTime("timeUpdated", java.time.LocalDateTime.class);

    public final StringPath tinNumber = createString("tinNumber");

    public QIdentity(String variable) {
        this(Identity.class, forVariable(variable), INITS);
    }

    public QIdentity(Path<? extends Identity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QIdentity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QIdentity(PathMetadata metadata, PathInits inits) {
        this(Identity.class, metadata, inits);
    }

    public QIdentity(Class<? extends Identity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.portalUser = inits.isInitialized("portalUser") ? new com.app.AIRS.entity.userManagement.QPortalUser(forProperty("portalUser"), inits.get("portalUser")) : null;
    }

}


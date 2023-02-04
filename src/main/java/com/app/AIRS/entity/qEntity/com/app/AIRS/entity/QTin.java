package com.app.AIRS.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QTin is a Querydsl query type for Tin
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QTin extends EntityPathBase<Tin> {

    private static final long serialVersionUID = 1198450905L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QTin tin = new QTin("tin");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final com.app.AIRS.entity.userManagement.QPortalUser portalUser;

    public final DateTimePath<java.time.LocalDateTime> timeCreated = createDateTime("timeCreated", java.time.LocalDateTime.class);

    public final DateTimePath<java.time.LocalDateTime> timeUpdated = createDateTime("timeUpdated", java.time.LocalDateTime.class);

    public final StringPath tinNumber = createString("tinNumber");

    public final EnumPath<com.app.AIRS.Enum.TinStatus> tinStatus = createEnum("tinStatus", com.app.AIRS.Enum.TinStatus.class);

    public final EnumPath<com.app.AIRS.Enum.TinType> tinType = createEnum("tinType", com.app.AIRS.Enum.TinType.class);

    public QTin(String variable) {
        this(Tin.class, forVariable(variable), INITS);
    }

    public QTin(Path<? extends Tin> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QTin(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QTin(PathMetadata metadata, PathInits inits) {
        this(Tin.class, metadata, inits);
    }

    public QTin(Class<? extends Tin> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.portalUser = inits.isInitialized("portalUser") ? new com.app.AIRS.entity.userManagement.QPortalUser(forProperty("portalUser"), inits.get("portalUser")) : null;
    }

}


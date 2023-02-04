package com.app.AIRS.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QUserRoles is a Querydsl query type for UserRoles
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QUserRoles extends EntityPathBase<UserRoles> {

    private static final long serialVersionUID = -2013179406L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QUserRoles userRoles = new QUserRoles("userRoles");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath name = createString("name");

    public final NumberPath<Long> role = createNumber("role", Long.class);

    public final DateTimePath<java.time.LocalDateTime> timeCreated = createDateTime("timeCreated", java.time.LocalDateTime.class);

    public final DateTimePath<java.time.LocalDateTime> timeUpdated = createDateTime("timeUpdated", java.time.LocalDateTime.class);

    public final QUser user;

    public QUserRoles(String variable) {
        this(UserRoles.class, forVariable(variable), INITS);
    }

    public QUserRoles(Path<? extends UserRoles> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QUserRoles(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QUserRoles(PathMetadata metadata, PathInits inits) {
        this(UserRoles.class, metadata, inits);
    }

    public QUserRoles(Class<? extends UserRoles> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.user = inits.isInitialized("user") ? new QUser(forProperty("user"), inits.get("user")) : null;
    }

}


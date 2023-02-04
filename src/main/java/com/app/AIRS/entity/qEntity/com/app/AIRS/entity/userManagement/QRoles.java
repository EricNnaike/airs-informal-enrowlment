package com.app.AIRS.entity.userManagement;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QRoles is a Querydsl query type for Roles
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QRoles extends EntityPathBase<Roles> {

    private static final long serialVersionUID = 388491965L;

    public static final QRoles roles = new QRoles("roles");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath name = createString("name");

    public QRoles(String variable) {
        super(Roles.class, forVariable(variable));
    }

    public QRoles(Path<? extends Roles> path) {
        super(path.getType(), path.getMetadata());
    }

    public QRoles(PathMetadata metadata) {
        super(Roles.class, metadata);
    }

}


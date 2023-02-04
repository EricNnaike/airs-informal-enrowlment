package com.app.AIRS.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QVersionControl is a Querydsl query type for VersionControl
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QVersionControl extends EntityPathBase<VersionControl> {

    private static final long serialVersionUID = -1326158555L;

    public static final QVersionControl versionControl = new QVersionControl("versionControl");

    public final StringPath description = createString("description");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath url = createString("url");

    public final NumberPath<Long> version = createNumber("version", Long.class);

    public QVersionControl(String variable) {
        super(VersionControl.class, forVariable(variable));
    }

    public QVersionControl(Path<? extends VersionControl> path) {
        super(path.getType(), path.getMetadata());
    }

    public QVersionControl(PathMetadata metadata) {
        super(VersionControl.class, metadata);
    }

}


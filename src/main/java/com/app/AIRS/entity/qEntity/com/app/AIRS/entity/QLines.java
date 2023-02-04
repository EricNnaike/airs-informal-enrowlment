package com.app.AIRS.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QLines is a Querydsl query type for Lines
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QLines extends EntityPathBase<Lines> {

    private static final long serialVersionUID = 652699455L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QLines lines = new QLines("lines");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final QMarkets market;

    public final StringPath name = createString("name");

    public QLines(String variable) {
        this(Lines.class, forVariable(variable), INITS);
    }

    public QLines(Path<? extends Lines> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QLines(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QLines(PathMetadata metadata, PathInits inits) {
        this(Lines.class, metadata, inits);
    }

    public QLines(Class<? extends Lines> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.market = inits.isInitialized("market") ? new QMarkets(forProperty("market"), inits.get("market")) : null;
    }

}


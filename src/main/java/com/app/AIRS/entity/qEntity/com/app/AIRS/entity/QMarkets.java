package com.app.AIRS.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMarkets is a Querydsl query type for Markets
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMarkets extends EntityPathBase<Markets> {

    private static final long serialVersionUID = 841284599L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMarkets markets = new QMarkets("markets");

    public final com.app.AIRS.entity.lgaArea.QLgaAreas area;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath name = createString("name");

    public QMarkets(String variable) {
        this(Markets.class, forVariable(variable), INITS);
    }

    public QMarkets(Path<? extends Markets> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMarkets(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMarkets(PathMetadata metadata, PathInits inits) {
        this(Markets.class, metadata, inits);
    }

    public QMarkets(Class<? extends Markets> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.area = inits.isInitialized("area") ? new com.app.AIRS.entity.lgaArea.QLgaAreas(forProperty("area")) : null;
    }

}


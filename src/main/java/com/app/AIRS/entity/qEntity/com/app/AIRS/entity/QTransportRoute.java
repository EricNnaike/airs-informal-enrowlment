package com.app.AIRS.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QTransportRoute is a Querydsl query type for TransportRoute
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QTransportRoute extends EntityPathBase<TransportRoute> {

    private static final long serialVersionUID = -488567712L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QTransportRoute transportRoute = new QTransportRoute("transportRoute");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath name = createString("name");

    public final QRoute transport;

    public QTransportRoute(String variable) {
        this(TransportRoute.class, forVariable(variable), INITS);
    }

    public QTransportRoute(Path<? extends TransportRoute> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QTransportRoute(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QTransportRoute(PathMetadata metadata, PathInits inits) {
        this(TransportRoute.class, metadata, inits);
    }

    public QTransportRoute(Class<? extends TransportRoute> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.transport = inits.isInitialized("transport") ? new QRoute(forProperty("transport")) : null;
    }

}


package com.app.AIRS.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QStreet is a Querydsl query type for Street
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QStreet extends EntityPathBase<Street> {

    private static final long serialVersionUID = -1030471741L;

    public static final QStreet street = new QStreet("street");

    public final NumberPath<Long> area = createNumber("area", Long.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Long> lga = createNumber("lga", Long.class);

    public final StringPath name = createString("name");

    public QStreet(String variable) {
        super(Street.class, forVariable(variable));
    }

    public QStreet(Path<? extends Street> path) {
        super(path.getType(), path.getMetadata());
    }

    public QStreet(PathMetadata metadata) {
        super(Street.class, metadata);
    }

}


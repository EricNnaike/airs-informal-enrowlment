package com.app.AIRS.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QBusinessClassification is a Querydsl query type for BusinessClassification
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QBusinessClassification extends EntityPathBase<BusinessClassification> {

    private static final long serialVersionUID = 1374855046L;

    public static final QBusinessClassification businessClassification = new QBusinessClassification("businessClassification");

    public final StringPath category = createString("category");

    public final StringPath description = createString("description");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Long> nature_of_busiess_fk = createNumber("nature_of_busiess_fk", Long.class);

    public QBusinessClassification(String variable) {
        super(BusinessClassification.class, forVariable(variable));
    }

    public QBusinessClassification(Path<? extends BusinessClassification> path) {
        super(path.getType(), path.getMetadata());
    }

    public QBusinessClassification(PathMetadata metadata) {
        super(BusinessClassification.class, metadata);
    }

}


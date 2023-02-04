package com.app.AIRS.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QEducationLevel is a Querydsl query type for EducationLevel
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QEducationLevel extends EntityPathBase<EducationLevel> {

    private static final long serialVersionUID = -618857348L;

    public static final QEducationLevel educationLevel = new QEducationLevel("educationLevel");

    public final StringPath degree = createString("degree");

    public final StringPath description = createString("description");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath schoolLevel = createString("schoolLevel");

    public final DateTimePath<java.time.LocalDateTime> timeCreated = createDateTime("timeCreated", java.time.LocalDateTime.class);

    public QEducationLevel(String variable) {
        super(EducationLevel.class, forVariable(variable));
    }

    public QEducationLevel(Path<? extends EducationLevel> path) {
        super(path.getType(), path.getMetadata());
    }

    public QEducationLevel(PathMetadata metadata) {
        super(EducationLevel.class, metadata);
    }

}


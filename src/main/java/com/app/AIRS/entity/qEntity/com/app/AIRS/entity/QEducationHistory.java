package com.app.AIRS.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QEducationHistory is a Querydsl query type for EducationHistory
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QEducationHistory extends EntityPathBase<EducationHistory> {

    private static final long serialVersionUID = -1159272564L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QEducationHistory educationHistory = new QEducationHistory("educationHistory");

    public final StringPath courseField = createString("courseField");

    public final BooleanPath deleted = createBoolean("deleted");

    public final QEducationLevel educationLevel;

    public final DatePath<java.time.LocalDate> endDate = createDate("endDate", java.time.LocalDate.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath schoolName = createString("schoolName");

    public final DatePath<java.time.LocalDate> startDate = createDate("startDate", java.time.LocalDate.class);

    public final DateTimePath<java.time.LocalDateTime> timeCreated = createDateTime("timeCreated", java.time.LocalDateTime.class);

    public final DateTimePath<java.time.LocalDateTime> timeUpdated = createDateTime("timeUpdated", java.time.LocalDateTime.class);

    public final QUser user;

    public QEducationHistory(String variable) {
        this(EducationHistory.class, forVariable(variable), INITS);
    }

    public QEducationHistory(Path<? extends EducationHistory> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QEducationHistory(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QEducationHistory(PathMetadata metadata, PathInits inits) {
        this(EducationHistory.class, metadata, inits);
    }

    public QEducationHistory(Class<? extends EducationHistory> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.educationLevel = inits.isInitialized("educationLevel") ? new QEducationLevel(forProperty("educationLevel")) : null;
        this.user = inits.isInitialized("user") ? new QUser(forProperty("user"), inits.get("user")) : null;
    }

}


package com.app.AIRS.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QOccupant is a Querydsl query type for Occupant
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QOccupant extends EntityPathBase<Occupant> {

    private static final long serialVersionUID = 855786877L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QOccupant occupant = new QOccupant("occupant");

    public final com.app.AIRS.entity.userManagement.QStatusEntity _super;

    public final StringPath address = createString("address");

    public final StringPath asin = createString("asin");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt;

    // inherited
    public final com.app.AIRS.entity.userManagement.QPortalUser createdBy;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> dateDeactivated;

    // inherited
    public final com.app.AIRS.entity.userManagement.QPortalUser deactivatedBy;

    public final StringPath fire = createString("fire");

    public final NumberPath<Long> fireId = createNumber("fireId", Long.class);

    public final StringPath firstName = createString("firstName");

    //inherited
    public final NumberPath<Long> id;

    public final StringPath lastName = createString("lastName");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> lastUpdatedAt;

    public final StringPath more = createString("more");

    public final QNIN nin;

    public final StringPath occupantType = createString("occupantType");

    public final StringPath others = createString("others");

    public final StringPath phoneNumber = createString("phoneNumber");

    public final StringPath premises = createString("premises");

    public final NumberPath<Long> premisesId = createNumber("premisesId", Long.class);

    public final StringPath presumptive = createString("presumptive");

    public final NumberPath<Long> presumptiveId = createNumber("presumptiveId", Long.class);

    public final QProperty property;

    public final StringPath residentType = createString("residentType");

    //inherited
    public final EnumPath<com.app.AIRS.Enum.GenericStatusConstant> status;

    public final DateTimePath<java.time.LocalDateTime> timeCreated = createDateTime("timeCreated", java.time.LocalDateTime.class);

    public final DateTimePath<java.time.LocalDateTime> timeUpdated = createDateTime("timeUpdated", java.time.LocalDateTime.class);

    public final StringPath waste = createString("waste");

    public final NumberPath<Long> wasteId = createNumber("wasteId", Long.class);

    public QOccupant(String variable) {
        this(Occupant.class, forVariable(variable), INITS);
    }

    public QOccupant(Path<? extends Occupant> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QOccupant(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QOccupant(PathMetadata metadata, PathInits inits) {
        this(Occupant.class, metadata, inits);
    }

    public QOccupant(Class<? extends Occupant> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this._super = new com.app.AIRS.entity.userManagement.QStatusEntity(type, metadata, inits);
        this.createdAt = _super.createdAt;
        this.createdBy = _super.createdBy;
        this.dateDeactivated = _super.dateDeactivated;
        this.deactivatedBy = _super.deactivatedBy;
        this.id = _super.id;
        this.lastUpdatedAt = _super.lastUpdatedAt;
        this.nin = inits.isInitialized("nin") ? new QNIN(forProperty("nin")) : null;
        this.property = inits.isInitialized("property") ? new QProperty(forProperty("property"), inits.get("property")) : null;
        this.status = _super.status;
    }

}


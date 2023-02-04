package com.app.AIRS.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QCorperate is a Querydsl query type for Corperate
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QCorperate extends EntityPathBase<Corperate> {

    private static final long serialVersionUID = 687936923L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QCorperate corperate = new QCorperate("corperate");

    public final com.app.AIRS.entity.userManagement.QStatusEntity _super;

    public final StringPath address = createString("address");

    public final NumberPath<Long> area = createNumber("area", Long.class);

    public final StringPath companyJob = createString("companyJob");

    public final StringPath companyType = createString("companyType");

    public final StringPath companyWork = createString("companyWork");

    public final StringPath corperateName = createString("corperateName");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt;

    // inherited
    public final com.app.AIRS.entity.userManagement.QPortalUser createdBy;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> dateDeactivated;

    // inherited
    public final com.app.AIRS.entity.userManagement.QPortalUser deactivatedBy;

    public final StringPath email = createString("email");

    //inherited
    public final NumberPath<Long> id;

    public final StringPath landmark = createString("landmark");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> lastUpdatedAt;

    public final NumberPath<Long> lga = createNumber("lga", Long.class);

    public final StringPath phonenumber = createString("phonenumber");

    public final com.app.AIRS.entity.userManagement.QPortalUser portalUser;

    public final StringPath rcNumber = createString("rcNumber");

    public final StringPath state = createString("state");

    //inherited
    public final EnumPath<com.app.AIRS.Enum.GenericStatusConstant> status;

    public final StringPath street = createString("street");

    public final DateTimePath<java.time.LocalDateTime> timeCreated = createDateTime("timeCreated", java.time.LocalDateTime.class);

    public final DateTimePath<java.time.LocalDateTime> timeUpdated = createDateTime("timeUpdated", java.time.LocalDateTime.class);

    public final StringPath TinNumber = createString("TinNumber");

    public QCorperate(String variable) {
        this(Corperate.class, forVariable(variable), INITS);
    }

    public QCorperate(Path<? extends Corperate> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QCorperate(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QCorperate(PathMetadata metadata, PathInits inits) {
        this(Corperate.class, metadata, inits);
    }

    public QCorperate(Class<? extends Corperate> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this._super = new com.app.AIRS.entity.userManagement.QStatusEntity(type, metadata, inits);
        this.createdAt = _super.createdAt;
        this.createdBy = _super.createdBy;
        this.dateDeactivated = _super.dateDeactivated;
        this.deactivatedBy = _super.deactivatedBy;
        this.id = _super.id;
        this.lastUpdatedAt = _super.lastUpdatedAt;
        this.portalUser = inits.isInitialized("portalUser") ? new com.app.AIRS.entity.userManagement.QPortalUser(forProperty("portalUser"), inits.get("portalUser")) : null;
        this.status = _super.status;
    }

}


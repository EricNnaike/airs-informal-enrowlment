package com.app.AIRS.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QBuilding_category is a Querydsl query type for Building_category
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QBuilding_category extends EntityPathBase<Building_category> {

    private static final long serialVersionUID = -1062773143L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QBuilding_category building_category = new QBuilding_category("building_category");

    public final com.app.AIRS.entity.userManagement.QStatusEntity _super;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt;

    // inherited
    public final com.app.AIRS.entity.userManagement.QPortalUser createdBy;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> dateDeactivated;

    // inherited
    public final com.app.AIRS.entity.userManagement.QPortalUser deactivatedBy;

    //inherited
    public final NumberPath<Long> id;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> lastUpdatedAt;

    public final StringPath name = createString("name");

    //inherited
    public final EnumPath<com.app.AIRS.Enum.GenericStatusConstant> status;

    public final QBuilding_type type;

    public QBuilding_category(String variable) {
        this(Building_category.class, forVariable(variable), INITS);
    }

    public QBuilding_category(Path<? extends Building_category> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QBuilding_category(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QBuilding_category(PathMetadata metadata, PathInits inits) {
        this(Building_category.class, metadata, inits);
    }

    public QBuilding_category(Class<? extends Building_category> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this._super = new com.app.AIRS.entity.userManagement.QStatusEntity(type, metadata, inits);
        this.createdAt = _super.createdAt;
        this.createdBy = _super.createdBy;
        this.dateDeactivated = _super.dateDeactivated;
        this.deactivatedBy = _super.deactivatedBy;
        this.id = _super.id;
        this.lastUpdatedAt = _super.lastUpdatedAt;
        this.status = _super.status;
        this.type = inits.isInitialized("type") ? new QBuilding_type(forProperty("type"), inits.get("type")) : null;
    }

}


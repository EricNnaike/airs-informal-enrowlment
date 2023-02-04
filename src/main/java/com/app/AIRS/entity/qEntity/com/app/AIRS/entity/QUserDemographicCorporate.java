package com.app.AIRS.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QUserDemographicCorporate is a Querydsl query type for UserDemographicCorporate
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QUserDemographicCorporate extends EntityPathBase<UserDemographicCorporate> {

    private static final long serialVersionUID = 650501739L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QUserDemographicCorporate userDemographicCorporate = new QUserDemographicCorporate("userDemographicCorporate");

    public final StringPath address = createString("address");

    public final StringPath branchAddress = createString("branchAddress");

    public final DatePath<java.time.LocalDate> businessCommencementDate = createDate("businessCommencementDate", java.time.LocalDate.class);

    public final StringPath city = createString("city");

    public final StringPath classification = createString("classification");

    public final StringPath companyTypeName = createString("companyTypeName");

    public final StringPath corporateName = createString("corporateName");

    public final StringPath corporateRcNumber = createString("corporateRcNumber");

    public final StringPath delistingStatus = createString("delistingStatus");

    public final StringPath headOfficeAddress = createString("headOfficeAddress");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final BooleanPath legacy = createBoolean("legacy");

    public final NumberPath<Long> lgaId = createNumber("lgaId", Long.class);

    public final StringPath natureOfBusinessName = createString("natureOfBusinessName");

    public final StringPath objectives = createString("objectives");

    public final StringPath phoneNumber = createString("phoneNumber");

    public final StringPath photo = createString("photo");

    public final BooleanPath registrationApproved = createBoolean("registrationApproved");

    public final NumberPath<Long> stateId = createNumber("stateId", Long.class);

    public final DateTimePath<java.time.LocalDateTime> timeCreated = createDateTime("timeCreated", java.time.LocalDateTime.class);

    public final DateTimePath<java.time.LocalDateTime> timeUpdated = createDateTime("timeUpdated", java.time.LocalDateTime.class);

    public final QUser user;

    public QUserDemographicCorporate(String variable) {
        this(UserDemographicCorporate.class, forVariable(variable), INITS);
    }

    public QUserDemographicCorporate(Path<? extends UserDemographicCorporate> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QUserDemographicCorporate(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QUserDemographicCorporate(PathMetadata metadata, PathInits inits) {
        this(UserDemographicCorporate.class, metadata, inits);
    }

    public QUserDemographicCorporate(Class<? extends UserDemographicCorporate> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.user = inits.isInitialized("user") ? new QUser(forProperty("user"), inits.get("user")) : null;
    }

}


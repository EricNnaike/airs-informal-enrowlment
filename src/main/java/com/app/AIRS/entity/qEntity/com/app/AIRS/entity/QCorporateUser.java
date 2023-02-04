package com.app.AIRS.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QCorporateUser is a Querydsl query type for CorporateUser
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QCorporateUser extends EntityPathBase<CorporateUser> {

    private static final long serialVersionUID = -1144289776L;

    public static final QCorporateUser corporateUser = new QCorporateUser("corporateUser");

    public final StringPath code = createString("code");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath name = createString("name");

    public QCorporateUser(String variable) {
        super(CorporateUser.class, forVariable(variable));
    }

    public QCorporateUser(Path<? extends CorporateUser> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCorporateUser(PathMetadata metadata) {
        super(CorporateUser.class, metadata);
    }

}


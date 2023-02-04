package com.app.AIRS.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QLgaType is a Querydsl query type for LgaType
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QLgaType extends EntityPathBase<LgaType> {

    private static final long serialVersionUID = 109189856L;

    public static final QLgaType lgaType = new QLgaType("lgaType");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath name = createString("name");

    public QLgaType(String variable) {
        super(LgaType.class, forVariable(variable));
    }

    public QLgaType(Path<? extends LgaType> path) {
        super(path.getType(), path.getMetadata());
    }

    public QLgaType(PathMetadata metadata) {
        super(LgaType.class, metadata);
    }

}


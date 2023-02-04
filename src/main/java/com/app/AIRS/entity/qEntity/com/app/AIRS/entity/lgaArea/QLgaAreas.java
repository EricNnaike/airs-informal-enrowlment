package com.app.AIRS.entity.lgaArea;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QLgaAreas is a Querydsl query type for LgaAreas
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QLgaAreas extends EntityPathBase<LgaAreas> {

    private static final long serialVersionUID = -532551109L;

    public static final QLgaAreas lgaAreas = new QLgaAreas("lgaAreas");

    public final StringPath code = createString("code");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Long> lgaId = createNumber("lgaId", Long.class);

    public final NumberPath<Long> lgaTypeId = createNumber("lgaTypeId", Long.class);

    public final StringPath name = createString("name");

    public final StringPath status = createString("status");

    public QLgaAreas(String variable) {
        super(LgaAreas.class, forVariable(variable));
    }

    public QLgaAreas(Path<? extends LgaAreas> path) {
        super(path.getType(), path.getMetadata());
    }

    public QLgaAreas(PathMetadata metadata) {
        super(LgaAreas.class, metadata);
    }

}


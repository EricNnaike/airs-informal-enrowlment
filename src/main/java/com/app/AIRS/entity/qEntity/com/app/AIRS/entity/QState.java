package com.app.AIRS.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QState is a Querydsl query type for State
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QState extends EntityPathBase<State> {

    private static final long serialVersionUID = 659479761L;

    public static final QState state = new QState("state");

    public final StringPath code = createString("code");

    public final StringPath countryFk = createString("countryFk");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath logo = createString("logo");

    public final StringPath name = createString("name");

    public final StringPath stateSlogan = createString("stateSlogan");

    public final StringPath website = createString("website");

    public final StringPath zoneFk = createString("zoneFk");

    public QState(String variable) {
        super(State.class, forVariable(variable));
    }

    public QState(Path<? extends State> path) {
        super(path.getType(), path.getMetadata());
    }

    public QState(PathMetadata metadata) {
        super(State.class, metadata);
    }

}


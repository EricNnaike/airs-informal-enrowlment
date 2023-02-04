package com.app.AIRS.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QAssessments is a Querydsl query type for Assessments
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QAssessments extends EntityPathBase<Assessments> {

    private static final long serialVersionUID = -1728804303L;

    public static final QAssessments assessments = new QAssessments("assessments");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath name = createString("name");

    public QAssessments(String variable) {
        super(Assessments.class, forVariable(variable));
    }

    public QAssessments(Path<? extends Assessments> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAssessments(PathMetadata metadata) {
        super(Assessments.class, metadata);
    }

}


package com.app.AIRS.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QAssessmentTypes is a Querydsl query type for AssessmentTypes
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QAssessmentTypes extends EntityPathBase<AssessmentTypes> {

    private static final long serialVersionUID = -1730813161L;

    public static final QAssessmentTypes assessmentTypes = new QAssessmentTypes("assessmentTypes");

    public final NumberPath<Double> amount = createNumber("amount", Double.class);

    public final NumberPath<Long> assessments = createNumber("assessments", Long.class);

    public final NumberPath<Long> category = createNumber("category", Long.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Long> lgaId = createNumber("lgaId", Long.class);

    public final StringPath name = createString("name");

    public QAssessmentTypes(String variable) {
        super(AssessmentTypes.class, forVariable(variable));
    }

    public QAssessmentTypes(Path<? extends AssessmentTypes> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAssessmentTypes(PathMetadata metadata) {
        super(AssessmentTypes.class, metadata);
    }

}


package com.app.AIRS.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QPaymentFrequency is a Querydsl query type for PaymentFrequency
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QPaymentFrequency extends EntityPathBase<PaymentFrequency> {

    private static final long serialVersionUID = 1142987190L;

    public static final QPaymentFrequency paymentFrequency = new QPaymentFrequency("paymentFrequency");

    public final NumberPath<Double> amount = createNumber("amount", Double.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath period = createString("period");

    public QPaymentFrequency(String variable) {
        super(PaymentFrequency.class, forVariable(variable));
    }

    public QPaymentFrequency(Path<? extends PaymentFrequency> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPaymentFrequency(PathMetadata metadata) {
        super(PaymentFrequency.class, metadata);
    }

}


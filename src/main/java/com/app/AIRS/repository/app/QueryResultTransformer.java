package com.app.AIRS.repository.app;

public interface QueryResultTransformer<E, T> {

    T transaform(E e);
}

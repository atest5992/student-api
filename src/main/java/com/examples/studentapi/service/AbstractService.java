package com.examples.studentapi.service;

import static java.util.Objects.isNull;

public interface AbstractService {

    default void checkId(Long entityId) {
        if (isNull(entityId) || entityId <= 0) {
            throw new RuntimeException("Target ID cannot be null,");
        }
    }
}

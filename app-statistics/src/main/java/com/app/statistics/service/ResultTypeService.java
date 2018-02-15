package com.app.statistics.service;

public interface ResultTypeService {
    void save(final String resultType);

    boolean exists(final String resultType);
}

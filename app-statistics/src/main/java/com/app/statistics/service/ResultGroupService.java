package com.app.statistics.service;

public interface ResultGroupService {
    void save(final String resultGroup);

    boolean exists(final String resultGroup);
}

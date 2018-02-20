package com.app.statistics.service;

import com.app.statistics.model.DashboardModel;

import java.util.List;

public interface DashboardService {

    void save(DashboardModel dashboardModel);

    boolean existsByName(final String name);

    void update(DashboardModel dashboardModel);

    List<DashboardModel> findAll();

    DashboardModel findByName(final String name);

    boolean deleteByName(final String name);
}

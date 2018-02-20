package com.app.statistics.service.impl;

import com.app.statistics.entity.DashboardEntity;
import com.app.statistics.exception.advice.RequestMatcherAdviceException;
import com.app.statistics.exception.advice.ResourceAlreadyExistsAdviceException;
import com.app.statistics.exception.advice.ResourceNotFoundAdviceException;
import com.app.statistics.mapper.BeanMapper;
import com.app.statistics.model.DashboardModel;
import com.app.statistics.repository.DashboardRepository;
import com.app.statistics.service.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.app.statistics.precondition.Precondition.checkIsFalse;
import static com.app.statistics.precondition.Precondition.checkIsTrue;
import static com.app.statistics.precondition.Precondition.checkNotNull;

@Service
public class DashboardServiceImpl implements DashboardService {
    @Autowired
    private DashboardRepository repository;

    @Autowired
    private BeanMapper mapper;

    @Override
    public void save(DashboardModel dashboardModel) {
        checkIsFalse(existsByName(dashboardModel.getName()), new ResourceAlreadyExistsAdviceException());

        final DashboardEntity dashboard = mapper.map(dashboardModel, DashboardEntity.class);
        checkNotNull(dashboard, new RequestMatcherAdviceException());

        dashboard.setCreateDate(new Date());
        repository.save(dashboard);
    }

    @Override
    public boolean existsByName(String name) {
        return repository.existsByName(name);
    }

    @Override
    public void update(DashboardModel dashboardModel) {
        checkIsTrue(existsByName(dashboardModel.getName()), new ResourceNotFoundAdviceException());

        DashboardEntity newDashboard = mapper.map(dashboardModel, DashboardEntity.class);
        checkNotNull(newDashboard, new RequestMatcherAdviceException());

        final DashboardEntity dashboardFromDB = repository.findByName(newDashboard.getName());
        checkNotNull((dashboardFromDB), new ResourceNotFoundAdviceException());

        newDashboard.setId(dashboardFromDB.getId());
        newDashboard.setCreateDate(dashboardFromDB.getCreateDate());
        newDashboard.setUpdateDate(new Date());
        repository.save(newDashboard);
    }

    @Override
    public List<DashboardModel> findAll() {
        final List<DashboardModel> result = new ArrayList<>();
        final List<DashboardEntity> dashboardEntities = repository.findAll();
        dashboardEntities.forEach(entity -> result.add(mapper.map(entity, DashboardModel.class)));

        return result;
    }

    @Override
    public DashboardModel findByName(String name) {
        final DashboardEntity dashboardEntity = repository.findByName(name);
        if (dashboardEntity == null) {
            return null;
        }

        return mapper.map(dashboardEntity, DashboardModel.class);
    }

    @Override
    public boolean deleteByName(String name) {
        if (existsByName(name)) {
            repository.deleteByName(name);
            return true;
        }
        return false;
    }
}

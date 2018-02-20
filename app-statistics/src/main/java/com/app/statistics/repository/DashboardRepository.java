package com.app.statistics.repository;

import com.app.statistics.entity.DashboardEntity;
import com.app.statistics.entity.ResultTypeEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DashboardRepository extends MongoRepository<DashboardEntity, String> {
    boolean existsByName(final String name);

    DashboardEntity findByName(final String name);

    void deleteByName(final String name);
}

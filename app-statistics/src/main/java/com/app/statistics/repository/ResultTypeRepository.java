package com.app.statistics.repository;

import com.app.statistics.entity.ResultTypeEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ResultTypeRepository extends MongoRepository<ResultTypeEntity, String> {
    boolean existsByType(final String type);

    ResultTypeEntity findByType(final String type);

    void deleteByType(final String type);
}

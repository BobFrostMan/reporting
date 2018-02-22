package com.app.statistics.repository;

import com.app.statistics.entity.ResultEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface ResultRepository extends MongoRepository<ResultEntity, String> {
    @Query(value = "{meta: {type: ?0}}")
    List<ResultEntity> findAllByType(final String type);
}

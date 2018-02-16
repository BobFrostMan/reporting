package com.app.statistics.repository;

import com.app.statistics.entity.ResultEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ResultRepository extends MongoRepository<ResultEntity, String> {
}

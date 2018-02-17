package com.app.statistics.repository;

import com.app.statistics.entity.TestResultEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TestResultRepository extends MongoRepository<TestResultEntity, String> {
}

package com.app.statistics.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@Document(collection = "TEST_RESULT")
public abstract class TestResultEntity {
    @Id
    private String id;
    private String testName;
    private TestResultType testResultType;
    private String description;
    private TestResultStatus result;
}

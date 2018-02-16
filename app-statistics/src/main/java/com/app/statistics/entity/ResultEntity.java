package com.app.statistics.entity;

import com.app.statistics.model.Group;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@Document(collection = "TEST_RESULT")
public abstract class ResultEntity {
    private String testName;
    private String description;
    private TestStatus result;
    private Group group;
}

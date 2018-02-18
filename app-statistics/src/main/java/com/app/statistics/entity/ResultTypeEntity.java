package com.app.statistics.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@Document(collection = "RESULT_TYPE")
public class ResultTypeEntity {
    @Id
    private String id;
    private String type;
    private List<ResultTypeFieldEntity> fields;
}

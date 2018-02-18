package com.app.statistics.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Map;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@Document(collection = "RESULT")
public class ResultEntity {
    @Id
    private String id;
    private ResultMetaEntity meta;
    private Map<String, Object> data;
}

package com.app.statistics.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class ResultTypeFieldEntity {
    private String fieldName;
    private String fieldType;
    private String fieldDescription;
    private List<ResultTypeFieldEntity> childrenFields;
}

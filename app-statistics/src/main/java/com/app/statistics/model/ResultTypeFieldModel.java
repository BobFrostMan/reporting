package com.app.statistics.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class ResultTypeFieldModel {
    private String fieldName;
    private String fieldType;
    private String fieldDescription;
    private List<ResultTypeFieldModel> childrenFields;
}

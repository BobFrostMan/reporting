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
public class ResultTypeModel {
    private String type;
    private List<ResultTypeFieldModel> fields;
}

package com.app.statistics.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class ResultTypeModel {
    private String type;
    private String description;
    private Date createDate;
    private Date updateDate;
    private List<ResultTypeFieldModel> fields;
}

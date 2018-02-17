package com.app.statistics.entity;

import com.app.statistics.annotation.ResultTypeMapping;
import com.app.statistics.model.MetaTypeModel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
import java.util.Map;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@ToString
@ResultTypeMapping(type = MetaTypeModel.DEFAULT)
public class DefaultTestResultEntity extends TestResultEntity {
    private String methodName;
    private Long startTime;
    private Long endTime;
    private List<Object> parameters;
    private Map<String, Object> additionalInfo;
}

package com.app.statistics.entity;

import com.app.statistics.annotation.ResultTypeMapping;
import com.app.statistics.model.Group;
import com.app.statistics.model.MetaType;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@ToString
@ResultTypeMapping(group = Group.GROUP1, type = MetaType.DEFAULT)
public class DefaultResultEntity extends ResultEntity {
    private String methodName;
    private Long startTime;
    private Long endTime;
    private List<Object> parameters;
    private Map<String, Object> additionalInfo;
}

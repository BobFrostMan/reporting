package com.app.statistics.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Map;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class ResultModel {
    private ResultMetaModel meta;
    private Map<String, Object> data;
}
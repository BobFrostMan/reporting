package com.app.statistics.annotation.handler;

import com.app.statistics.entity.ResultEntity;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class ResultMappingItem {
    private String groupName;
    private Map<String, Class<? extends ResultEntity>> typeMapping = new HashMap<>();

    public ResultMappingItem(String groupName) {
        this.groupName = groupName;
    }

    public boolean exist(final String type) {
        return typeMapping.containsKey(type);
    }

    public void add(final String type, final Class<? extends ResultEntity> clazz) {
        typeMapping.put(type, clazz);
    }
}

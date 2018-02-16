package com.app.statistics.annotation.handler;

import com.app.statistics.entity.ResultEntity;
import com.app.statistics.model.Group;
import com.app.statistics.model.MetaType;
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
    private Group groupName;
    private Map<MetaType, Class<? extends ResultEntity>> typeMapping = new HashMap<>();

    public ResultMappingItem(Group groupName) {
        this.groupName = groupName;
    }

    public boolean exist(final MetaType type) {
        return typeMapping.containsKey(type);
    }

    public void add(final MetaType type, final Class<? extends ResultEntity> clazz) {
        typeMapping.put(type, clazz);
    }
}

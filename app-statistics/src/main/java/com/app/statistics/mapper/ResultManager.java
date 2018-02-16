package com.app.statistics.mapper;

import com.app.statistics.annotation.handler.ResultMappingAnnotationHandler;
import com.app.statistics.entity.ResultEntity;
import com.app.statistics.model.Group;
import com.app.statistics.model.MetaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;


@Service
@Scope("singleton")
public class ResultManager {
    @Autowired
    private ResultMappingAnnotationHandler mappingAnnotationHandler;

    public Class<? extends ResultEntity> findResultDataClass(final Group group, final MetaType type) {
        return mappingAnnotationHandler.findEntityClassForRequest(group, type);
    }
}

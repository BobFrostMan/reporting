package com.app.statistics.mapper;

import com.app.statistics.annotation.handler.ResultMappingAnnotationHandler;
import com.app.statistics.entity.TestResultEntity;
import com.app.statistics.model.MetaTypeModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;


@Service
@Scope("singleton")
public class ResultManager {
    @Autowired
    private ResultMappingAnnotationHandler mappingAnnotationHandler;

    public Class<? extends TestResultEntity> findResultDataClass(final MetaTypeModel type) {
        return mappingAnnotationHandler.findEntityClassForRequest(type);
    }
}

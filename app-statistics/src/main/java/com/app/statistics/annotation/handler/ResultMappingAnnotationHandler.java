package com.app.statistics.annotation.handler;

import com.app.statistics.annotation.ResultTypeMapping;
import com.app.statistics.entity.TestResultEntity;
import com.app.statistics.model.MetaTypeModel;
import org.reflections.Reflections;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.*;

@Component
@Scope("singleton")
public class ResultMappingAnnotationHandler {
    private static final String PACKAGE_WITH_CLASSES = "com.app.statistics.entity";
    private Map<MetaTypeModel, Class<? extends TestResultEntity>> entityTypeContainer = new HashMap<>();

    public Class<? extends TestResultEntity> findEntityClassForRequest(final MetaTypeModel type) {
       return entityTypeContainer.get(type);
    }

    @PostConstruct
    private void initContainer() {
        final Reflections reflections = new Reflections(PACKAGE_WITH_CLASSES);
        final Set<Class<?>> allClasses = reflections.getTypesAnnotatedWith(ResultTypeMapping.class);
        for (Class clazz : allClasses) {
            final ResultTypeMapping annotation = (ResultTypeMapping) clazz.getAnnotation(ResultTypeMapping.class);
            entityTypeContainer.put(annotation.type(), clazz);
        }
    }
}

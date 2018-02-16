package com.app.statistics.annotation.handler;

import com.app.statistics.annotation.ResultTypeMapping;
import com.app.statistics.entity.ResultEntity;
import com.app.statistics.exception.ResultMappingContainerInitializationException;
import com.app.statistics.model.Group;
import com.app.statistics.model.MetaType;
import org.reflections.Reflections;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.*;

@Component
@Scope("singleton")
public class ResultMappingAnnotationHandler {
    private static final String PACKAGE_WITH_CLASSES = "com.app.statistics.entity";

    private final List<ResultMappingItem> requestMappingContainer = new ArrayList<>();

    public Class<? extends ResultEntity> findEntityClassForRequest(final Group group, final MetaType type) {
        final ResultMappingItem mappingItem = findResultTypeMappingItem(group);
        if (mappingItem == null) {
            return null;
        }

        return mappingItem.getTypeMapping().get(type);
    }

    @PostConstruct
    private void initContainer() {
        for (Map.Entry<Class<? extends ResultEntity>, ResultTypeMapping> typeMapping : findResultMappingAnnotation().entrySet()) {
            addToContainer(typeMapping.getKey(), typeMapping.getValue());
        }
    }

    private Map<Class<? extends ResultEntity>, ResultTypeMapping> findResultMappingAnnotation() {
        final Map<Class<? extends ResultEntity>, ResultTypeMapping> typeMapping = new HashMap<>();
        final Reflections reflections = new Reflections(PACKAGE_WITH_CLASSES);
        final Set<Class<?>> allClasses = reflections.getTypesAnnotatedWith(ResultTypeMapping.class);

        for (Class clazz : allClasses) {
            typeMapping.put(clazz, (ResultTypeMapping) clazz.getAnnotation(ResultTypeMapping.class));
        }
        return typeMapping;
    }

    private void addToContainer(final Class<? extends ResultEntity> clazz, final ResultTypeMapping annotation) {
        final MetaType type = annotation.type();
        final Group group = annotation.group();
        ResultMappingItem mappingItem = findResultTypeMappingItem(group);


        if (mappingItem != null) {
            mappingItem.add(type, clazz);
            return;
        }

        mappingItem = new ResultMappingItem(annotation.group());

        if (mappingItem.exist(type)) {
            throw new ResultMappingContainerInitializationException(
                    String.format("Item with group: [%s] and type: [%s] already added to container.", group, type));
        }

        mappingItem.add(type, clazz);
        requestMappingContainer.add(mappingItem);
    }

    private ResultMappingItem findResultTypeMappingItem(final Group groupName) {
        for (ResultMappingItem item : requestMappingContainer) {
            if (item.getGroupName().equals(groupName)) {
                return item;
            }
        }
        return null;
    }
}

package com.app.statistics.mapper.converter.impl;

import com.app.statistics.entity.DefaultResultEntity;
import com.app.statistics.entity.TestStatus;
import com.app.statistics.mapper.converter.CustomResultConverter;
import com.app.statistics.model.Group;
import com.app.statistics.model.ResultModel;
import com.app.statistics.util.ValueMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class DefaultResultConverter extends CustomResultConverter<DefaultResultEntity>{

    private static final String TEST_NAME_PROPERTY = "testName";
    private static final String GROUP_PROPERTY = "group";
    private static final String RESULT_PROPERTY = "result";
    private static final String DESCRIPTION_PROPERTY = "description";
    private static final String METHOD_NAME_PROPERTY = "methodName";
    private static final String START_TIME_PROPERTY = "startTime";
    private static final String END_TIME_PROPERTY = "endTime";
    private static final String PARAMETERS_PROPERTY = "parameters";
    private static final String ADDITIONAL_INFO_PROPERTY = "additionalInfo";

    @Override
    protected ResultModel resultEntityToResultModel(final DefaultResultEntity resultEntity) {
        if (resultEntity == null) {
            return null;
        }
        final Map<String, Object> data = new HashMap<>();
        data.put(METHOD_NAME_PROPERTY, resultEntity.getMethodName());
        data.put(TEST_NAME_PROPERTY, resultEntity.getTestName());
        data.put(DESCRIPTION_PROPERTY, resultEntity.getDescription());
        data.put(RESULT_PROPERTY, resultEntity.getResult());
        data.put(START_TIME_PROPERTY, resultEntity.getStartTime());
        data.put(END_TIME_PROPERTY, resultEntity.getEndTime());
        data.put(PARAMETERS_PROPERTY, resultEntity.getParameters());
        data.put(ADDITIONAL_INFO_PROPERTY, resultEntity.getAdditionalInfo());

        final ResultModel resultModel = new ResultModel();
        resultModel.setData(data);
        return resultModel;
    }

    @Override
    protected DefaultResultEntity resultModelToResultEntity(final ResultModel resultModel) {
        if (resultModel == null) {
            return null;
        }

        final ValueMap properties = new ValueMap(resultModel.getData());
        if(properties.isEmpty()) {
            return null;
        }

        final DefaultResultEntity resultEntity = new DefaultResultEntity();
        resultEntity.setTestName(properties.get(TEST_NAME_PROPERTY, String.class));
        resultEntity.setGroup(properties.getEnum(GROUP_PROPERTY, Group.class));
        resultEntity.setResult(properties.getEnum(RESULT_PROPERTY, TestStatus.class, TestStatus.FAILED));
        resultEntity.setDescription(properties.get(DESCRIPTION_PROPERTY, String.class));
        resultEntity.setMethodName(properties.get(METHOD_NAME_PROPERTY, String.class));
        resultEntity.setStartTime(properties.get(START_TIME_PROPERTY, Long.class));
        resultEntity.setEndTime(properties.get(END_TIME_PROPERTY, Long.class));
        resultEntity.setParameters(properties.get(PARAMETERS_PROPERTY, ArrayList.class));
        resultEntity.setAdditionalInfo(properties.get(ADDITIONAL_INFO_PROPERTY, LinkedHashMap.class));

        return resultEntity;
    }

    @Override
    protected Class getEntityClass() {
        return DefaultResultEntity.class;
    }
}

package com.app.statistics.mapper.converter.impl;

import com.app.statistics.entity.DefaultTestResultEntity;
import com.app.statistics.entity.TestResultStatus;
import com.app.statistics.entity.TestResultType;
import com.app.statistics.mapper.converter.CustomResultConverter;
import com.app.statistics.model.MetaTypeModel;
import com.app.statistics.model.ResultMetaModel;
import com.app.statistics.model.ResultModel;
import com.app.statistics.util.EnumUtil;
import com.app.statistics.util.ValueMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class DefaultResultConverter extends CustomResultConverter<DefaultTestResultEntity>{

    private static final String TEST_NAME_PROPERTY = "testName";
    private static final String RESULT_PROPERTY = "result";
    private static final String DESCRIPTION_PROPERTY = "description";
    private static final String METHOD_NAME_PROPERTY = "methodName";
    private static final String START_TIME_PROPERTY = "startTime";
    private static final String END_TIME_PROPERTY = "endTime";
    private static final String PARAMETERS_PROPERTY = "parameters";
    private static final String ADDITIONAL_INFO_PROPERTY = "additionalInfo";

    @Override
    protected ResultModel resultEntityToResultModel(final DefaultTestResultEntity resultEntity) {
        if (resultEntity == null) {
            return null;
        }
        final ResultModel resultModel = new ResultModel();

        final Map<String, Object> data = new HashMap<>();
        data.put(METHOD_NAME_PROPERTY, resultEntity.getMethodName());
        data.put(TEST_NAME_PROPERTY, resultEntity.getTestName());
        data.put(DESCRIPTION_PROPERTY, resultEntity.getDescription());
        data.put(RESULT_PROPERTY, resultEntity.getResult());
        data.put(START_TIME_PROPERTY, resultEntity.getStartTime());
        data.put(END_TIME_PROPERTY, resultEntity.getEndTime());
        data.put(PARAMETERS_PROPERTY, resultEntity.getParameters());
        data.put(ADDITIONAL_INFO_PROPERTY, resultEntity.getAdditionalInfo());
        resultModel.setData(data);

        final ResultMetaModel metaModel = new ResultMetaModel();
        metaModel.setType(EnumUtil.adaptEnum(resultEntity.getTestResultType(), MetaTypeModel.class));

        return resultModel;
    }

    @Override
    protected DefaultTestResultEntity resultModelToResultEntity(final ResultModel resultModel) {
        if (resultModel == null) {
            return null;
        }

        final ValueMap properties = new ValueMap(resultModel.getData());
        if(properties.isEmpty()) {
            return null;
        }

        final DefaultTestResultEntity resultEntity = new DefaultTestResultEntity();
        resultEntity.setTestName(properties.get(TEST_NAME_PROPERTY, String.class));
        resultEntity.setResult(properties.getEnum(RESULT_PROPERTY, TestResultStatus.class, TestResultStatus.FAILED));
        resultEntity.setDescription(properties.get(DESCRIPTION_PROPERTY, String.class));
        resultEntity.setMethodName(properties.get(METHOD_NAME_PROPERTY, String.class));
        resultEntity.setStartTime(properties.get(START_TIME_PROPERTY, Long.class));
        resultEntity.setEndTime(properties.get(END_TIME_PROPERTY, Long.class));
        resultEntity.setParameters(properties.get(PARAMETERS_PROPERTY, ArrayList.class));
        resultEntity.setAdditionalInfo(properties.get(ADDITIONAL_INFO_PROPERTY, LinkedHashMap.class));

        final ResultMetaModel resultMetaModel = resultModel.getMeta();
        if (resultMetaModel != null) {
            resultEntity.setTestResultType(EnumUtil.adaptEnum(resultMetaModel.getType(), TestResultType.class));
        }

        return resultEntity;
    }

    @Override
    protected Class getEntityClass() {
        return DefaultTestResultEntity.class;
    }
}

package com.app.statistics.mapper.converter.impl;

import com.app.statistics.entity.TestResultEntity;
import com.app.statistics.mapper.converter.CustomResultConverter;
import com.app.statistics.model.ResultModel;

import java.util.HashMap;
import java.util.Map;

public class TestCustomResultConverter extends CustomResultConverter<TestResultEntity> {
    @Override
    protected ResultModel resultEntityToResultModel(TestResultEntity resultEntity) {
        if (resultEntity == null) {
            return null;
        }
        final ResultModel resultModel = new ResultModel();
        resultModel.setMeta(convertMeta(resultEntity.getMeta()));

        final Map<String, Object> data = new HashMap<>();
        data.put("testField", resultEntity.getTestField());
        resultModel.setData(data);

        return resultModel;
    }

    @Override
    protected TestResultEntity resultModelToResultEntity(ResultModel resultModel) {
        if (resultModel == null) {
            return null;
        }
        final TestResultEntity resultEntity = new TestResultEntity();
        resultEntity.setMeta(convertMeta(resultModel.getMeta()));

        final Map<String, Object> data = resultModel.getData();
        if (data != null && !data.isEmpty()) {
            resultEntity.setTestField((String) data.get("testField"));
        }
        return resultEntity;
    }

    @Override
    protected Class getEntityClass() {
        return TestResultEntity.class;
    }


}

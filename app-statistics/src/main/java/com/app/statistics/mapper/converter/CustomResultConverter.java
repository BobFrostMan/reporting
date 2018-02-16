package com.app.statistics.mapper.converter;

import com.app.statistics.entity.ResultEntity;
import com.app.statistics.model.ResultModel;
import org.dozer.CustomConverter;

public abstract class CustomResultConverter<T extends ResultEntity> implements CustomConverter {

    @Override
    public Object convert(Object destination, Object source, Class destClass, Class sourceClass) {
        if (source == null) {
            return null;
        }
        if (sourceClass.equals(getEntityClass())) {
            return resultEntityToResultModel((T) source);
        } else if (sourceClass.equals(ResultModel.class)) {
            return resultModelToResultEntity((ResultModel) source);
        }
        return null;
    }

    protected abstract ResultModel resultEntityToResultModel(final T source);

    protected abstract T resultModelToResultEntity(final ResultModel source);

    protected abstract Class getEntityClass();
}

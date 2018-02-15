package com.app.statistics.mapper.converter;

import com.app.statistics.entity.ResultMetaEntity;
import com.app.statistics.entity.ResultEntity;
import com.app.statistics.entity.ResultTypeEntity;
import com.app.statistics.model.ResultMetaModel;
import com.app.statistics.model.ResultModel;

import org.dozer.CustomConverter;


public abstract class CustomResultConverter<T extends ResultEntity> implements CustomConverter {

    @Override
    public Object convert(Object destination, Object source, Class destClass, Class sourceClass) {
        if (sourceClass.equals(getEntityClass())) {
            return resultEntityToResultModel((T) source);
        } else if (sourceClass.equals(ResultModel.class)) {
            return resultModelToResultEntity((ResultModel) source);
        }
        return null;
    }

    protected abstract ResultModel resultEntityToResultModel(final T resultEntity);

    protected abstract T resultModelToResultEntity(final ResultModel resultModel);

    protected abstract Class getEntityClass();

    protected ResultMetaEntity convertMeta(final ResultMetaModel resultMetaModel) {
        if (resultMetaModel == null) {
            return null;
        }
        final ResultMetaEntity resultMetaEntity = new ResultMetaEntity();
        resultMetaEntity.setType(new ResultTypeEntity(resultMetaModel.getType()));

        return resultMetaEntity;
    }

    protected ResultMetaModel convertMeta(final ResultMetaEntity resultMetaEntity) {
        if (resultMetaEntity == null) {
            return null;
        }
        final ResultMetaModel resultMetaModel = new ResultMetaModel();
        final ResultTypeEntity resultType = resultMetaEntity.getType();
        if (resultType != null) {
            resultMetaModel.setType(resultType.getTypeName());
        }

        return resultMetaModel;
    }
}

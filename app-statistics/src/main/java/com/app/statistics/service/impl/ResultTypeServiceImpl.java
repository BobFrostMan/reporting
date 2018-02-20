package com.app.statistics.service.impl;

import com.app.statistics.entity.ResultTypeEntity;
import com.app.statistics.exception.advice.RequestMatcherAdviceException;
import com.app.statistics.exception.advice.ResourceAlreadyExistsAdviceException;
import com.app.statistics.exception.advice.ResourceNotFoundAdviceException;
import com.app.statistics.mapper.BeanMapper;
import com.app.statistics.model.ResultTypeModel;
import com.app.statistics.repository.ResultTypeRepository;
import com.app.statistics.service.ResultTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.app.statistics.precondition.Precondition.checkIsFalse;
import static com.app.statistics.precondition.Precondition.checkIsTrue;
import static com.app.statistics.precondition.Precondition.checkNotNull;

@Service
public class ResultTypeServiceImpl implements ResultTypeService {

    @Autowired
    private ResultTypeRepository repository;

    @Autowired
    private BeanMapper mapper;

    @Override
    public void save(final ResultTypeModel resultTypeModel) {
        checkIsFalse(existsByType(resultTypeModel.getType()), new ResourceAlreadyExistsAdviceException());

        final ResultTypeEntity result = mapper.map(resultTypeModel, ResultTypeEntity.class);
        checkNotNull(result, new RequestMatcherAdviceException());

        result.setCreateDate(new Date());
        repository.save(result);
    }

    @Override
    public void update(final ResultTypeModel resultTypeModel) {
        checkIsTrue(existsByType(resultTypeModel.getType()), new ResourceNotFoundAdviceException());

        ResultTypeEntity newResult = mapper.map(resultTypeModel, ResultTypeEntity.class);
        checkNotNull(newResult, new RequestMatcherAdviceException());

        final ResultTypeEntity resultFromDB = repository.findByType(newResult.getType());
        checkNotNull((resultFromDB), new ResourceNotFoundAdviceException());

        newResult.setId(resultFromDB.getId());
        newResult.setCreateDate(resultFromDB.getCreateDate());
        newResult.setUpdateDate(new Date());
        repository.save(newResult);
    }

    @Override
    public List<ResultTypeModel> findAll() {
        final List<ResultTypeModel> result = new ArrayList<>();
        final List<ResultTypeEntity> typeDescriptionEntities = repository.findAll();
        typeDescriptionEntities.forEach(entity -> result.add(mapper.map(entity, ResultTypeModel.class)));

        return result;
    }

    @Override
    public ResultTypeModel findByType(final String type) {
        final ResultTypeEntity resultTypeEntity = repository.findByType(type);
        if (resultTypeEntity == null) {
            return null;
        }

        return mapper.map(resultTypeEntity, ResultTypeModel.class);
    }

    @Override
    public boolean existsByType(final String type) {
        return repository.existsByType(type);
    }

    @Override
    public boolean deleteByType(final String type) {
        if (existsByType(type)) {
            repository.deleteByType(type);
            return true;
        }
        return false;
    }
}

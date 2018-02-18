package com.app.statistics.service.impl;

import com.app.statistics.entity.ResultTypeEntity;
import com.app.statistics.exception.advice.ResourceAlreadyExistsAdviceException;
import com.app.statistics.mapper.BeanMapper;
import com.app.statistics.model.ResultTypeModel;
import com.app.statistics.repository.ResultTypeRepository;
import com.app.statistics.service.ResultTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ResultTypeServiceImpl implements ResultTypeService {

    @Autowired
    private ResultTypeRepository repository;

    @Autowired
    private BeanMapper mapper;

    @Override
    public void save(final ResultTypeModel typeDescriptionModel) {
        final ResultTypeEntity result = mapper.map(typeDescriptionModel, ResultTypeEntity.class);
        if (existsByType(typeDescriptionModel.getType())) {
            throw new ResourceAlreadyExistsAdviceException();
        }

        repository.save(result);
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

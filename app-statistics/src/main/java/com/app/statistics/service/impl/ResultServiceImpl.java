package com.app.statistics.service.impl;

import com.app.statistics.entity.ResultEntity;
import com.app.statistics.exception.advice.RequestMatcherAdviceException;
import com.app.statistics.mapper.BeanMapper;
import com.app.statistics.model.ResultModel;
import com.app.statistics.repository.ResultRepository;
import com.app.statistics.service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.app.statistics.precondition.Precondition.checkNotNull;

@Service
public class ResultServiceImpl implements ResultService {
    @Autowired
    private ResultRepository resultRepository;

    @Autowired
    private BeanMapper mapper;

    @Override
    public void save(final ResultModel result) {
        final ResultEntity entity = mapper.map(result, ResultEntity.class);
        checkNotNull(entity, new RequestMatcherAdviceException());

        resultRepository.save(entity);
    }

    @Override
    public List<ResultEntity> findAllByType(final String type) {
        return resultRepository.findAllByType(type);
    }
}

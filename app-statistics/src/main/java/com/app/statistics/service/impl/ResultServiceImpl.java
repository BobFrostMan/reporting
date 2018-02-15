package com.app.statistics.service.impl;

import com.app.statistics.entity.ResultEntity;
import com.app.statistics.entity.ResultGroupEntity;
import com.app.statistics.exception.advice.IncorrectResultBodyAdviceException;
import com.app.statistics.exception.advice.IncorrectResultGroupAdviceException;
import com.app.statistics.exception.advice.IncorrectResultTypeAdviceException;
import com.app.statistics.exception.advice.RequestMatcherAdviceException;
import com.app.statistics.mapper.BeanMapper;
import com.app.statistics.model.ResultModel;
import com.app.statistics.mapper.ResultManager;
import com.app.statistics.repository.ResultRepository;
import com.app.statistics.service.ResultGroupService;
import com.app.statistics.service.ResultService;
import com.app.statistics.service.ResultTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.app.statistics.precondition.Precondition.checkArgument;
import static com.app.statistics.precondition.Precondition.checkNotNull;

@Service
public class ResultServiceImpl implements ResultService {
    @Autowired
    private ResultRepository resultRepository;

    @Autowired
    private ResultGroupService resultGroupService;

    @Autowired
    private ResultTypeService resultTypeService;

    @Autowired
    private ResultManager resultManager;

    @Autowired
    private BeanMapper mapper;

    @Override
    public void save(final String group, final ResultModel result) {
        checkNotNull(result, new IncorrectResultBodyAdviceException());
        checkNotNull(result.getMeta(), new IncorrectResultBodyAdviceException());
        checkNotNull(result.getData(), new IncorrectResultBodyAdviceException());
        checkNotNull(group, new IncorrectResultGroupAdviceException());

        checkArgument(resultGroupService.exists(group), new IncorrectResultGroupAdviceException());
        final String type = result.getMeta().getType();
        checkArgument(resultTypeService.exists(type), new IncorrectResultTypeAdviceException());

        final ResultEntity entity = mapRequest(group, type, result);
        checkNotNull(entity, new RequestMatcherAdviceException());

        resultRepository.save(entity);
        resultRepository.flush();
    }

    private ResultEntity mapRequest(final String group, final String type, final ResultModel result) {
        final Class<? extends ResultEntity> requestDataEntity = resultManager.findRequestDataClass(group, type);
        checkNotNull(requestDataEntity, new IncorrectResultBodyAdviceException());

        final ResultEntity entity = mapper.map(result, requestDataEntity);
        entity.setResultGroup(new ResultGroupEntity(group));

        return entity;
    }
}

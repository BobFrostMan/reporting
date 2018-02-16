package com.app.statistics.service.impl;

import com.app.statistics.entity.ResultEntity;
import com.app.statistics.exception.advice.IncorrectResultBodyAdviceException;
import com.app.statistics.exception.advice.IncorrectResultDataAdviceException;
import com.app.statistics.exception.advice.IncorrectResultMetaAdviceException;
import com.app.statistics.exception.advice.RequestMatcherAdviceException;
import com.app.statistics.mapper.BeanMapper;
import com.app.statistics.mapper.ResultManager;
import com.app.statistics.model.MetaType;
import com.app.statistics.model.ResultModel;
import com.app.statistics.repository.ResultRepository;
import com.app.statistics.service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.app.statistics.precondition.Precondition.checkNotNull;

@Service
public class TestResultServiceImpl implements ResultService {
    @Autowired
    private ResultRepository resultRepository;

    @Autowired
    private ResultManager resultManager;

    @Autowired
    private BeanMapper mapper;

    @Override
    public void save(final ResultModel result) {
        checkNotNull(result, new IncorrectResultBodyAdviceException());
        checkNotNull(result.getMeta(), new IncorrectResultMetaAdviceException());
        checkNotNull(result.getData(), new IncorrectResultDataAdviceException());

        final MetaType type = result.getMeta().getType();
        checkNotNull(type, new IncorrectResultMetaAdviceException());

        final ResultEntity entity = mapRequest(type, result);
        checkNotNull(entity, new RequestMatcherAdviceException());

        resultRepository.save(entity);
    }

    private ResultEntity mapRequest(final MetaType type, final ResultModel result) {
        final Class<? extends ResultEntity> requestDataEntity = resultManager.findResultDataClass(type);
        checkNotNull(requestDataEntity, new IncorrectResultBodyAdviceException());

        return mapper.map(result, requestDataEntity);
    }
}

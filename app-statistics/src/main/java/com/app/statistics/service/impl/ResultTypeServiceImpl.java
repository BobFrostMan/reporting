package com.app.statistics.service.impl;

import com.app.statistics.entity.ResultTypeEntity;
import com.app.statistics.exception.advice.IncorrectResultTypeAdviceException;
import com.app.statistics.exception.advice.ResultTypeAlreadyExistAdviceException;
import com.app.statistics.precondition.Precondition;
import com.app.statistics.repository.ResultTypeRepository;
import com.app.statistics.service.ResultTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResultTypeServiceImpl implements ResultTypeService {
    @Autowired
    private ResultTypeRepository resultTypeRepository;

    @Override
    public void save(String resultType) {
        Precondition.checkArgument(resultType == null, new IncorrectResultTypeAdviceException());
        Precondition.checkArgument(exists(resultType), new ResultTypeAlreadyExistAdviceException());

        resultTypeRepository.save(new ResultTypeEntity(resultType));
        resultTypeRepository.flush();
    }

    @Override
    public boolean exists(String resultType) {
        if (resultType == null) {
            return false;
        }
        return resultTypeRepository.exists(resultType);
    }
}

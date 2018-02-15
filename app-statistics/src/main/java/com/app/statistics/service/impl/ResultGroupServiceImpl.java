package com.app.statistics.service.impl;

import com.app.statistics.entity.ResultGroupEntity;
import com.app.statistics.exception.advice.IncorrectResultGroupAdviceException;
import com.app.statistics.exception.advice.ResultGroupAlreadyExistAdviceException;
import com.app.statistics.precondition.Precondition;
import com.app.statistics.repository.ResultGroupRepository;
import com.app.statistics.service.ResultGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResultGroupServiceImpl implements ResultGroupService {
    @Autowired
    private ResultGroupRepository resultGroupRepository;

    @Override
    public void save(final String resultGroup) {
        Precondition.checkArgument(resultGroup == null, new IncorrectResultGroupAdviceException());
        Precondition.checkArgument(exists(resultGroup), new ResultGroupAlreadyExistAdviceException());

        resultGroupRepository.save(new ResultGroupEntity(resultGroup));
        resultGroupRepository.flush();
    }

    public boolean exists(final String resultGroup) {
        if (resultGroup == null) {
            return false;
        }
        return resultGroupRepository.exists(resultGroup);
    }
}

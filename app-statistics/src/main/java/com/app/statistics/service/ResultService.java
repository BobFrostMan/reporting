package com.app.statistics.service;

import com.app.statistics.entity.ResultEntity;
import com.app.statistics.model.ResultModel;

import java.util.List;

public interface ResultService {
    void save(final ResultModel result);

    List<ResultEntity> findAllByType(String type);
}

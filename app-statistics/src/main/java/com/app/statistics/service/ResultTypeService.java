package com.app.statistics.service;

import com.app.statistics.model.ResultTypeModel;

import java.util.List;

public interface ResultTypeService {

    void save(ResultTypeModel typeDescription);

    List<ResultTypeModel> findAll();

    ResultTypeModel findByType(String type);

    boolean existsByType(String type);

    boolean deleteByType(String type);
}

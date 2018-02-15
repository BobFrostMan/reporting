package com.app.statistics.service;

import com.app.statistics.model.ResultModel;

public interface ResultService {
    void save(final String group, final ResultModel result);
}

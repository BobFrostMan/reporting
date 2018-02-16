package com.app.statistics.service;

import com.app.statistics.model.Group;
import com.app.statistics.model.ResultModel;

public interface ResultService {
    void save(final Group group, final ResultModel result);
}

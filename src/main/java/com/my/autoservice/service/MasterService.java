package com.my.autoservice.service;

import com.my.autoservice.model.Favor;
import com.my.autoservice.model.Master;

public interface MasterService {
    Master create(Master master);

    Master save(Master master);

    Master getById(Long id);

    Master addFavor(Favor favor);
}

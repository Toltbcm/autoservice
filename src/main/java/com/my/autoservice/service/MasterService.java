package com.my.autoservice.service;

import com.my.autoservice.model.Master;

public interface MasterService {
    Master save(Master master);

    Master getById(Long id);
}

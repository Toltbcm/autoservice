package com.my.autoservice.service;

import com.my.autoservice.dto.request.MasterCreateDto;
import com.my.autoservice.model.Master;

public interface MasterService {
    Master create(MasterCreateDto dto);

    Master save(Master master);
}

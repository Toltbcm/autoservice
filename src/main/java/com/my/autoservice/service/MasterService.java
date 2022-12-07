package com.my.autoservice.service;

import com.my.autoservice.model.Favor;
import com.my.autoservice.model.Master;
import java.math.BigDecimal;

public interface MasterService {
    Master create(Master master);

    Master save(Master master);

    Master getById(Long id);

    Master addFavor(Favor favor);

    BigDecimal getSalary(Long id);
}

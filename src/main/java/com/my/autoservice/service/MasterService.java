package com.my.autoservice.service;

import com.my.autoservice.model.Master;
import com.my.autoservice.model.Order;

public interface MasterService {
    Master create(Master master);

    Master save(Master master);

    Master getById(Long id);

    Master addOrder(Long id, Order order);
}

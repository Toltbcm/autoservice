package com.my.autoservice.service;

import com.my.autoservice.model.Order;

public interface OrderService {
    Order create(Order order);

    Order save(Order order);

    Order getById(Long id);
}

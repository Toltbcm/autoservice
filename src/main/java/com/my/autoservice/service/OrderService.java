package com.my.autoservice.service;

import com.my.autoservice.model.Order;
import java.util.List;

public interface OrderService {
    Order save(Order order);

    Order getById(Long id);

    List<Order> getAllByMasterId(Long id);
//    List<Order> getAllByOwnerId(Long id);
}

package com.my.autoservice.service;

import com.my.autoservice.model.Favor;
import com.my.autoservice.model.Order;
import com.my.autoservice.model.Part;

public interface OrderService {
    Order create(Order order);

    Order save(Order order);

    Order getById(Long id);

    Order addFavor(Favor favor);

    Order addPart(Long id, Part part);
}

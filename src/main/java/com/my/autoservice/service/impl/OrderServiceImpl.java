package com.my.autoservice.service.impl;

import com.my.autoservice.model.Order;
import com.my.autoservice.repository.OrderRepository;
import com.my.autoservice.service.CarService;
import com.my.autoservice.service.OrderService;
import com.my.autoservice.service.OwnerService;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final OwnerService ownerService;

    public OrderServiceImpl(OrderRepository orderRepository, OwnerService ownerService, CarService carService) {
        this.orderRepository = orderRepository;
        this.ownerService = ownerService;
    }

    @Override
    public Order save(Order order) {
        Long owner_id = ownerService.getByCarId(order.getCar().getId()).getId();
        order = orderRepository.save(order);
        ownerService.addOrder(owner_id, order);
        return order;
    }

    @Override
    public Order getById(Long id) {
        return orderRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Can't find order by Id: " + id));
    }
}

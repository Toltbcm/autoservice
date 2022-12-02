package com.my.autoservice.service.impl;

import com.my.autoservice.model.Order;
import com.my.autoservice.repository.OrderRepository;
import com.my.autoservice.service.OrderService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Order save(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Order getById(Long id) {
        return orderRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Can't find order by Id: " + id));
    }

    @Override
    public List<Order> getAllByMasterId(Long id) {
        return null;
//        return orderRepository.getAllByMasterId(id);
    }
//    @Override
//    public List<Order> getAllByOwnerId(Long id) {
//        return orderRepository.findAllByOwnerId(id);
//    }
}

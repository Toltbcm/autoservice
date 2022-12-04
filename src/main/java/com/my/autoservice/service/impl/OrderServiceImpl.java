package com.my.autoservice.service.impl;

import com.my.autoservice.model.Favor;
import com.my.autoservice.model.Order;
import com.my.autoservice.model.OrderStatus;
import com.my.autoservice.model.Part;
import com.my.autoservice.repository.OrderRepository;
import com.my.autoservice.service.CarService;
import com.my.autoservice.service.OrderService;
import com.my.autoservice.service.OwnerService;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final OwnerService ownerService;

    public OrderServiceImpl(OrderRepository orderRepository,
            OwnerService ownerService, CarService carService) {
        this.orderRepository = orderRepository;
        this.ownerService = ownerService;
    }

    @Override
    public Order create(Order order) {
        order.setFavors(new ArrayList<>());
        order.setParts(new ArrayList<>());
        order.setStatus(OrderStatus.ACCEPTED);
        order.setStartTime(LocalDateTime.now());
        order.setFinishTime(LocalDateTime.of(0, Month.JANUARY,
                1, 0, 0, 0, 0));
        order.setTotalPrice(BigDecimal.ZERO);
        order = orderRepository.save(order);
        ownerService.addOrder(order);
        return order;
    }

    @Override
    public Order save(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Order getById(Long id) {
        return orderRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Can't find order by ID: " + id));
    }

    @Override
    public Order addFavor(Favor favor) {
        Order order = favor.getOrder();
        List<Favor> favors = order.getFavors();
        favors.add(favor);
        order.setFavors(favors);
        return save(order);
    }

    @Override
    public Order addPart(Long id, Part part) {
        Order order = getById(id);
        List<Part> parts = order.getParts();
        parts.add(part);
        order.setParts(parts);
        return save(order);
    }
}

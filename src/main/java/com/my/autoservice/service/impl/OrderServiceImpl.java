package com.my.autoservice.service.impl;

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
    private final CarService carService;

    public OrderServiceImpl(OrderRepository orderRepository,
            OwnerService ownerService, CarService carService) {
        this.orderRepository = orderRepository;
        this.ownerService = ownerService;
        this.carService = carService;
    }

    @Override
    public Order create(Long carId, Order order) {
        order.setCar(carService.getById(carId));
        order.setServices(new ArrayList<>());
        order.setParts(new ArrayList<>());
        order.setStatus(OrderStatus.ACCEPTED);
        order.setStartTime(LocalDateTime.now());
        order.setFinishTime(LocalDateTime.of(0, Month.JANUARY,
                1, 0, 0, 0, 0));
        order.setTotalPrice(BigDecimal.ZERO);
        order = orderRepository.save(order);
        Long ownerId = ownerService.getByCarId(carId).getId();
        ownerService.addOrder(ownerId, order);
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

    public Order addService(Long id, com.my.autoservice.service.Service service) {
        return null;
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

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
    private static final BigDecimal PART_DISCOUNT = BigDecimal.valueOf(0.01);
    private static final BigDecimal FAVOR_DISCOUNT = BigDecimal.valueOf(0.02);
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
        BigDecimal discount = favor.getPrice().multiply(FAVOR_DISCOUNT.multiply(
                BigDecimal.valueOf(order.getCar().getOwner().getOrders().size())));
        favor.setPrice(favor.getPrice().subtract(discount));
        favors.add(favor);
        order.setFavors(favors);
        order.setTotalPrice(order.getTotalPrice().add(favor.getPrice()));
        return save(order);
    }

    @Override
    public Order addPart(Long id, Part part) {
        Order order = getById(id);
        List<Part> parts = order.getParts();
        parts.add(part);
        BigDecimal discount = PART_DISCOUNT.multiply(
                BigDecimal.valueOf(order.getCar().getOwner().getOrders().size()));
        order.setParts(parts);
        order.setTotalPrice(order.getTotalPrice().add(
                part.getPrice().subtract(part.getPrice().multiply(discount))));
        return save(order);
    }
}

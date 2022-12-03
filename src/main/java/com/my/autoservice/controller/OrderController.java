package com.my.autoservice.controller;

import com.my.autoservice.dto.mapper.RequestDtoMapper;
import com.my.autoservice.dto.mapper.ResponseDtoMapper;
import com.my.autoservice.dto.request.OrderRequestDto;
import com.my.autoservice.dto.response.OrderResponseDto;
import com.my.autoservice.model.Order;
import com.my.autoservice.model.OrderStatus;
import com.my.autoservice.service.OrderService;
import com.my.autoservice.service.OwnerService;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {
    private final OrderService orderService;
    private final RequestDtoMapper<OrderRequestDto, Order> requestDtoMapper;
    private final ResponseDtoMapper<OrderResponseDto, Order> responseDtoMapper;

    public OrderController(OrderService orderService,
            OwnerService ownerService, RequestDtoMapper<OrderRequestDto, Order> requestDtoMapper,
            ResponseDtoMapper<OrderResponseDto, Order> responseDtoMapper) {
        this.orderService = orderService;
        this.requestDtoMapper = requestDtoMapper;
        this.responseDtoMapper = responseDtoMapper;
    }

    @PostMapping("/add")
    public OrderResponseDto create(@RequestBody OrderRequestDto orderRequestDto) {
        Order order = requestDtoMapper.mapToModel(orderRequestDto);
        order.setServices(new ArrayList<>());
        order.setParts(new ArrayList<>());
        order.setStatus(OrderStatus.ACCEPTED);
        order.setStartTime(LocalDateTime.now());
        order.setFinishTime(LocalDateTime.now());
        order.setTotalPrice(BigDecimal.ZERO);
        return responseDtoMapper.mapToDto(orderService.save(order));
    }

//    @PutMapping
}

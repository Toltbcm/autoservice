package com.my.autoservice.controller;

import com.my.autoservice.dto.mapper.RequestDtoMapper;
import com.my.autoservice.dto.mapper.ResponseDtoMapper;
import com.my.autoservice.dto.request.OrderRequestDto;
import com.my.autoservice.dto.response.OrderResponseDto;
import com.my.autoservice.model.Order;
import com.my.autoservice.service.CarService;
import com.my.autoservice.service.OrderService;
import com.my.autoservice.service.PartService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {
    private final OrderService orderService;
    private final PartService partService;
    private final CarService carService;
    private final RequestDtoMapper<OrderRequestDto, Order> requestDtoMapper;
    private final ResponseDtoMapper<OrderResponseDto, Order> responseDtoMapper;

    public OrderController(OrderService orderService,
            PartService partService, CarService carService,
            RequestDtoMapper<OrderRequestDto, Order> requestDtoMapper,
            ResponseDtoMapper<OrderResponseDto, Order> responseDtoMapper) {
        this.orderService = orderService;
        this.partService = partService;
        this.carService = carService;
        this.requestDtoMapper = requestDtoMapper;
        this.responseDtoMapper = responseDtoMapper;
    }

    @PostMapping("/add/car//{id}")
    public OrderResponseDto create(@PathVariable Long id,
            @RequestBody OrderRequestDto orderRequestDto) {
        Order order = requestDtoMapper.mapToModel(orderRequestDto);
        return responseDtoMapper.mapToDto(orderService.create(id, order));
    }

    @PostMapping("/add//{id}/part//{partId}")
    public OrderResponseDto addPart(@PathVariable Long id, @PathVariable Long partId) {
        return responseDtoMapper.mapToDto(
                orderService.addPart(id, partService.getById(partId)));
    }
}

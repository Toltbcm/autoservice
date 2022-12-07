package com.my.autoservice.controller;

import com.my.autoservice.dto.mapper.RequestDtoMapper;
import com.my.autoservice.dto.mapper.ResponseDtoMapper;
import com.my.autoservice.dto.request.OrderRequestDto;
import com.my.autoservice.dto.response.OrderResponseDto;
import com.my.autoservice.model.Favor;
import com.my.autoservice.model.Order;
import com.my.autoservice.model.OrderStatus;
import com.my.autoservice.service.CarService;
import com.my.autoservice.service.OrderService;
import com.my.autoservice.service.PartService;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

    @PostMapping("/add")
    public OrderResponseDto create(
            @RequestBody OrderRequestDto orderRequestDto) {
        Order order = requestDtoMapper.mapToModel(orderRequestDto);
        return responseDtoMapper.mapToDto(orderService.create(order));
    }

    @PutMapping("/update//{orderId}")
    public OrderResponseDto create(@PathVariable Long orderId,
            @RequestBody OrderRequestDto orderRequestDto) {
        Order order = requestDtoMapper.mapToModel(orderRequestDto);
        order.setId(orderId);
        return responseDtoMapper.mapToDto(orderService.save(order));
    }

    @PostMapping("/add//{orderId}/part//{partId}")
    public OrderResponseDto addPart(@PathVariable Long orderId, @PathVariable Long partId) {
        return responseDtoMapper.mapToDto(
                orderService.addPart(orderId, partService.getById(partId)));
    }

    @PutMapping("/{orderId}/status//{orderStatus}")
    public OrderResponseDto changeStatus(@PathVariable Long orderId,
            @PathVariable String orderStatus) {
        Order order = orderService.getById(orderId);
        OrderStatus status = OrderStatus.valueOf(orderStatus.toUpperCase());
        if (status == OrderStatus.SUCCESSFUL || status == OrderStatus.NOT_SUCCESSFUL) {
            order.setFinishTime(LocalDateTime.now());
        }
        order.setStatus(status);
        return responseDtoMapper.mapToDto(orderService.save(order));
    }

    @GetMapping("/price//{orderId}")
    public BigDecimal getPrice(@PathVariable Long orderId) {
        Order order = orderService.getById(orderId);
        List<Favor> favors = order.getFavors();
        BigDecimal diagnosticPrice = favors.stream()
                .filter(f -> f.getDescription().equals("Diagnostic"))
                .map(Favor::getPrice)
                .findAny().orElse(BigDecimal.ZERO);
        BigDecimal price = order.getTotalPrice();
        return !diagnosticPrice.equals(BigDecimal.ZERO) && favors.size() > 1
               ? price.subtract(diagnosticPrice)
               : price;
    }
}

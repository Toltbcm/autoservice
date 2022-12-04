package com.my.autoservice.dto.mapper;

import com.my.autoservice.dto.request.OrderRequestDto;
import com.my.autoservice.dto.response.OrderResponseDto;
import com.my.autoservice.model.Favor;
import com.my.autoservice.model.Order;
import com.my.autoservice.model.Part;
import com.my.autoservice.service.CarService;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper implements ResponseDtoMapper<OrderResponseDto, Order>,
        RequestDtoMapper<OrderRequestDto, Order> {
    private final CarService carService;

    public OrderMapper(CarService carService) {
        this.carService = carService;
    }

    @Override
    public OrderResponseDto mapToDto(Order order) {
        OrderResponseDto dto = new OrderResponseDto();
        dto.setId(order.getId());
        dto.setStatus(order.getStatus());
        dto.setStartTime(order.getStartTime());
        dto.setFinishTime(order.getFinishTime());
        dto.setCarId(order.getCar().getId());
        dto.setFavorsId(order.getFavors().stream()
                .map(Favor::getId)
                .collect(Collectors.toList()));
        dto.setPartIds(order.getParts().stream()
                .map(Part::getId)
                .collect(Collectors.toList()));
        dto.setProblemDescription(order.getProblemDescription());
        dto.setTotalPrice(order.getTotalPrice());
        return dto;
    }

    @Override
    public Order mapToModel(OrderRequestDto dto) {
        Order order = new Order();
        order.setCar(carService.getById(dto.getCarId()));
        order.setProblemDescription(dto.getProblemDescription());
        return order;
    }
}

package com.my.autoservice.dto.mapper;

import com.my.autoservice.dto.request.OwnerRequestDto;
import com.my.autoservice.dto.response.OwnerResponseDto;
import com.my.autoservice.model.Car;
import com.my.autoservice.model.Order;
import com.my.autoservice.model.Owner;
import com.my.autoservice.service.CarService;
import com.my.autoservice.service.OrderService;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class OwnerMapper implements RequestDtoMapper<OwnerRequestDto, Owner>,
        ResponseDtoMapper<OwnerResponseDto, Owner> {

    private final CarService carService;
    private final OrderService orderService;

    public OwnerMapper(CarService carService, OrderService orderService) {
        this.carService = carService;
        this.orderService = orderService;
    }

    @Override
    public Owner mapToModel(OwnerRequestDto dto) {
        Owner owner = new Owner();
        owner.setCars(dto.getCarIds().stream()
                .map(carService::getById)
                .collect(Collectors.toList()));
        owner.setOrders(dto.getOrderIds().stream()
                .map(orderService::getById)
                .collect(Collectors.toList()));
        return owner;
    }

    @Override
    public OwnerResponseDto mapToDto(Owner owner) {
        OwnerResponseDto dto = new OwnerResponseDto();
        dto.setId(owner.getId());
        dto.setCarIds(owner.getCars().stream()
                .map(Car::getId)
                .collect(Collectors.toList()));
        dto.setOrderIds((owner.getOrders().stream()
                .map(Order::getId))
                .collect(Collectors.toList()));
        return dto;
    }
}

package com.my.autoservice.dto.mapper;

import com.my.autoservice.dto.request.OrderRequestDto;
import com.my.autoservice.dto.response.OrderResponseDto;
import com.my.autoservice.model.Order;
import com.my.autoservice.model.Part;
import com.my.autoservice.model.Service;
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
        OrderResponseDto orderResponseDto = new OrderResponseDto();
        orderResponseDto.setId(order.getId());
        orderResponseDto.setStatus(order.getStatus());
        orderResponseDto.setStartTime(order.getStartTime());
        orderResponseDto.setFinishTime(order.getFinishTime());
        orderResponseDto.setCar_id(order.getCar().getId());
        orderResponseDto.setServiceIds(order.getServices().stream()
                .map(Service::getId)
                .collect(Collectors.toList()));
        orderResponseDto.setPartIds(order.getParts().stream()
                .map(Part::getId)
                .collect(Collectors.toList()));
        orderResponseDto.setProblemDescription(order.getProblemDescription());
        orderResponseDto.setTotalPrice(order.getTotalPrice());
        return orderResponseDto;
    }

    @Override
    public Order mapToModel(OrderRequestDto dto) {
        Order order = new Order();
        order.setCar(carService.getById(dto.getCarId()));
        order.setProblemDescription(dto.getProblemDescription());
//        order.setStartTime(LocalDateTime.now());
//        order.setFinishTime(LocalDateTime.now());
//        order.setTotalPrice(BigDecimal.ZERO);
//        order.setParts(new ArrayList<>());
//        order.setServices(new ArrayList<>());
//        order.setStatus(OrderStatus.ACCEPTED);
        return order;
    }
}

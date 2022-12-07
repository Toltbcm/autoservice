package com.my.autoservice.dto.mapper;

import com.my.autoservice.dto.request.FavorRequestDto;
import com.my.autoservice.dto.response.FavorResponseDto;
import com.my.autoservice.model.Favor;
import com.my.autoservice.service.MasterService;
import com.my.autoservice.service.OrderService;
import org.springframework.stereotype.Component;

@Component
public class FavorMapper implements RequestDtoMapper<FavorRequestDto, Favor>,
        ResponseDtoMapper<FavorResponseDto, Favor> {
    private final OrderService orderService;
    private final MasterService masterService;

    public FavorMapper(OrderService orderService, MasterService masterService) {
        this.orderService = orderService;
        this.masterService = masterService;
    }

    @Override
    public Favor mapToModel(FavorRequestDto dto) {
        Favor favor = new Favor();
        favor.setOrder(orderService.getById(dto.getOrderId()));
        favor.setMaster(masterService.getById(dto.getMasterId()));
        favor.setPrice(dto.getPrice());
        return favor;
    }

    @Override
    public FavorResponseDto mapToDto(Favor favor) {
        FavorResponseDto dto = new FavorResponseDto();
        dto.setId(favor.getId());
        dto.setOrderId(favor.getOrder().getId());
        dto.setMasterId(favor.getMaster().getId());
        dto.setPrice(favor.getPrice());
        dto.setPaymentStatus(favor.getPaymentStatus());
        return dto;
    }
}

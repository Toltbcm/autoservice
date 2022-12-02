package com.my.autoservice.dto.mapper;

import com.my.autoservice.dto.request.MasterRequestDto;
import com.my.autoservice.dto.response.MasterResponseDto;
import com.my.autoservice.model.Master;
import com.my.autoservice.service.OrderService;
import org.springframework.stereotype.Component;

@Component
public class MasterMapper implements RequestDtoMapper<MasterRequestDto, Master>,
        ResponseDtoMapper<MasterResponseDto, Master> {
    private final OrderService orderService;

    public MasterMapper(OrderService orderService) {
        this.orderService = orderService;
    }

    @Override
    public Master mapToModel(MasterRequestDto dto) {
        Master master = new Master();
        master.setFirstName(dto.getFirstName());
        master.setLastName(dto.getLastName());
        master.setPatronymic(dto.getPatronymic());
//        master.setCompletedOrders(orderService.getAllByMasterId());
        return master;
    }

    public Master mapToModel(Long id, MasterRequestDto dto) {
        Master master = new Master();
        master.setFirstName(dto.getFirstName());
        master.setLastName(dto.getLastName());
        master.setPatronymic(dto.getPatronymic());
        master.setCompletedOrders(orderService.getAllByMasterId(id));
        return master;
    }

    @Override
    public MasterResponseDto mapToDto(Master model) {
        return null;
    }
}

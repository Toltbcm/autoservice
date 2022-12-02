package com.my.autoservice.dto.mapper;

import com.my.autoservice.dto.request.OwnerRequestDto;
import com.my.autoservice.dto.response.OwnerResponseDto;
import com.my.autoservice.model.Car;
import com.my.autoservice.model.Order;
import com.my.autoservice.model.Owner;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class OwnerMapper implements RequestDtoMapper<OwnerRequestDto, Owner>,
        ResponseDtoMapper<OwnerResponseDto, Owner> {
    @Override
    public Owner mapToModel(OwnerRequestDto dto) {
        Owner owner = new Owner();
        owner.setLicenseNumber(dto.getLicenseNumber());
        return owner;
    }

    @Override
    public OwnerResponseDto mapToDto(Owner owner) {
        OwnerResponseDto dto = new OwnerResponseDto();
        dto.setId(owner.getId());
        dto.setLicenseNumber(owner.getLicenseNumber());
        dto.setCarIds(owner.getCars().stream()
                .map(Car::getId)
                .collect(Collectors.toList()));
        dto.setOrderIds((owner.getOrders().stream()
                .map(Order::getId))
                .collect(Collectors.toList()));
        return dto;
    }
}

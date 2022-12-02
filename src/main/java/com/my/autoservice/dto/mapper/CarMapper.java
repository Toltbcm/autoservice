package com.my.autoservice.dto.mapper;

import com.my.autoservice.dto.request.CarRequestDto;
import com.my.autoservice.dto.response.CarResponseDto;
import com.my.autoservice.model.Car;
import com.my.autoservice.service.OwnerService;
import org.springframework.stereotype.Component;

@Component
public class CarMapper implements RequestDtoMapper<CarRequestDto, Car>,
        ResponseDtoMapper<CarResponseDto, Car> {
    private final OwnerService ownerService;

    public CarMapper(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @Override
    public Car mapToModel(CarRequestDto dto) {
        Car car = new Car();
        car.setManufacturer(dto.getManufacturer());
        car.setModel(dto.getModel());
        car.setSerialNumber(dto.getSerialNumber());
        car.setProductionYear(dto.getProductionYear());
        car.setOwner(ownerService.getById(dto.getOwnerId()));
        return car;
    }

    @Override
    public CarResponseDto mapToDto(Car car) {
        CarResponseDto dto = new CarResponseDto();
        dto.setId(car.getId());
        dto.setManufacturer(car.getManufacturer());
        dto.setModel(car.getModel());
        dto.setSerialNumber(car.getSerialNumber());
        dto.setProductionYear(car.getProductionYear());
        dto.setOwnerId(car.getOwner().getId());
        return dto;
    }
}

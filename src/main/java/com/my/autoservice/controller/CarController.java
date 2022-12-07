package com.my.autoservice.controller;

import com.my.autoservice.dto.mapper.RequestDtoMapper;
import com.my.autoservice.dto.mapper.ResponseDtoMapper;
import com.my.autoservice.dto.request.CarRequestDto;
import com.my.autoservice.dto.response.CarResponseDto;
import com.my.autoservice.model.Car;
import com.my.autoservice.service.CarService;
import com.my.autoservice.service.OwnerService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/car")
public class CarController {
    private final CarService carService;
    private final OwnerService ownerService;
    private final RequestDtoMapper<CarRequestDto, Car> requestDtoMapper;
    private final ResponseDtoMapper<CarResponseDto, Car> responseDtoMapper;

    public CarController(CarService carService,
            OwnerService ownerService, RequestDtoMapper<CarRequestDto, Car> requestDtoMapper,
            ResponseDtoMapper<CarResponseDto, Car> responseDtoMapper) {
        this.carService = carService;
        this.ownerService = ownerService;
        this.requestDtoMapper = requestDtoMapper;
        this.responseDtoMapper = responseDtoMapper;
    }

    @PostMapping("/add")
    public CarResponseDto create(@RequestBody CarRequestDto carRequestDto) {
        Car car = requestDtoMapper.mapToModel(carRequestDto);
        return responseDtoMapper.mapToDto(carService.save(car));
    }

    @PutMapping("/update//{carId}")
    public CarResponseDto update(@PathVariable Long carId,
            @RequestBody CarRequestDto carRequestDto) {
        Car car = requestDtoMapper.mapToModel(carRequestDto);
        car.setId(carId);
        return responseDtoMapper.mapToDto(carService.save(car));
    }
}

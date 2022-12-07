package com.my.autoservice.service.impl;

import com.my.autoservice.model.Car;
import com.my.autoservice.repository.CarRepository;
import com.my.autoservice.service.CarService;
import com.my.autoservice.service.OwnerService;
import org.springframework.stereotype.Service;

@Service
public class CarServiceImpl implements CarService {
    private final CarRepository carRepository;
    private final OwnerService ownerService;

    public CarServiceImpl(CarRepository carRepository, OwnerService ownerService) {
        this.carRepository = carRepository;
        this.ownerService = ownerService;
    }

    @Override
    public Car create(Car car) {
        ownerService.addCar(car);
        return carRepository.save(car);
    }

    @Override
    public Car save(Car car) {
        return carRepository.save(car);
    }

    @Override
    public Car getById(Long id) {
        return carRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Can't find car by ID: " + id));
    }
}

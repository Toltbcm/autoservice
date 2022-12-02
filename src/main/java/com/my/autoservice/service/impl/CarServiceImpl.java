package com.my.autoservice.service.impl;

import com.my.autoservice.model.Car;
import com.my.autoservice.repository.CarRepository;
import com.my.autoservice.service.CarService;
import org.springframework.stereotype.Service;

@Service
public class CarServiceImpl implements CarService {
    private final CarRepository carRepository;

    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public Car save(Car car) {
        return carRepository.save(car);
    }

    @Override
    public Car getById(Long id) {
        return carRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Can't find car by Id: " + id));
    }
}

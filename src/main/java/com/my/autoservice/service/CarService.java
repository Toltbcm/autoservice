package com.my.autoservice.service;

import com.my.autoservice.model.Car;

public interface CarService {
    Car create(Car car);

    Car save(Car car);

    Car getById(Long id);
}

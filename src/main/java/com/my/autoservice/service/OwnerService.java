package com.my.autoservice.service;

import com.my.autoservice.model.Car;
import com.my.autoservice.model.Order;
import com.my.autoservice.model.Owner;

public interface OwnerService {
    Owner save(Owner owner);

    Owner addCar(Long id, Car car);

    Owner addOrder(Long id, Order order);

    Owner getById(Long id);
}

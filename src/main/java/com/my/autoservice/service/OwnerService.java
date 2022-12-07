package com.my.autoservice.service;

import com.my.autoservice.model.Car;
import com.my.autoservice.model.Order;
import com.my.autoservice.model.Owner;
import java.util.List;

public interface OwnerService {
    Owner create(Owner owner);

    Owner save(Owner owner);

    Owner addCar(Car car);

    Owner addOrder(Order order);

    Owner getById(Long id);
}

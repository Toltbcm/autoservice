package com.my.autoservice.service;

import com.my.autoservice.dto.request.OwnerCreateDto;
import com.my.autoservice.model.Car;
import com.my.autoservice.model.Order;
import com.my.autoservice.model.Owner;

public interface OwnerService {

    Owner create(OwnerCreateDto dto);

    Owner save(Owner owner);

    Owner addCar(Long id, Car car);

    Owner getById(Long id);
}

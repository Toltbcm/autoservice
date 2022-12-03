package com.my.autoservice.service.impl;

import com.my.autoservice.model.Car;
import com.my.autoservice.model.Order;
import com.my.autoservice.model.Owner;
import com.my.autoservice.repository.OwnerRepository;
import com.my.autoservice.service.OwnerService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class OwnerServiceImpl implements OwnerService {
    private final OwnerRepository ownerRepository;

    public OwnerServiceImpl(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    @Override
    public Owner create(Owner owner) {
        owner.setCars(new ArrayList<>());
        owner.setOrders(new ArrayList<>());
        return ownerRepository.save(owner);
    }

    @Override
    public Owner save(Owner owner) {
        return ownerRepository.save(owner);
    }

    @Override
    public Owner addCar(Long id, Car car) {
        Owner owner = getById(id);
        List<Car> cars = owner.getCars();
        cars.add(car);
        owner.setCars(cars);
        return save(owner);
    }

    @Override
    public Owner addOrder(Long id, Order order) {
        Owner owner = getById(id);
        List<Order> orders = owner.getOrders();
        orders.add(order);
        owner.setOrders(orders);
        return save(owner);
    }

    @Override
    public Owner getById(Long id) {
        return ownerRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Can't find owner by ID: " + id));
    }

    @Override
    public Owner getByCarId(Long id) {
        return ownerRepository.findOwnerByCarsId(id);
    }
}

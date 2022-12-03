package com.my.autoservice.service.impl;

import com.my.autoservice.model.Master;
import com.my.autoservice.model.Order;
import com.my.autoservice.repository.MasterRepository;
import com.my.autoservice.service.MasterService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class MasterServiceImpl implements MasterService {
    private final MasterRepository masterRepository;

    public MasterServiceImpl(MasterRepository masterRepository) {
        this.masterRepository = masterRepository;
    }

    @Override
    public Master create(Master master) {
        master.setOrders(new ArrayList<>());
        return masterRepository.save(master);
    }

    @Override
    public Master save(Master master) {
        return masterRepository.save(master);
    }

    @Override
    public Master getById(Long id) {
        return masterRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Can't get master by ID: " + id));
    }

    @Override
    public Master addOrder(Long id, Order order) {
        Master master = getById(id);
        List<Order> orders = master.getOrders();
        orders.add(order);
        master.setOrders(orders);
        return save(master);
    }
}

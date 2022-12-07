package com.my.autoservice.service.impl;

import com.my.autoservice.model.Favor;
import com.my.autoservice.model.PaymentStatus;
import com.my.autoservice.repository.FavorRepository;
import com.my.autoservice.service.FavorService;
import com.my.autoservice.service.MasterService;
import com.my.autoservice.service.OrderService;
import org.springframework.stereotype.Service;

@Service
public class FavorServiceImpl implements FavorService {
    private final FavorRepository favorRepository;
    private final MasterService masterService;
    private final OrderService orderService;

    public FavorServiceImpl(FavorRepository favorRepository,
            MasterService masterService,
            OrderService orderService) {
        this.favorRepository = favorRepository;
        this.masterService = masterService;
        this.orderService = orderService;
    }

    @Override
    public Favor create(Favor favor) {
        favor.setPaymentStatus(PaymentStatus.NOT_PAYED);
        favor = save(favor);
        masterService.addFavor(favor);
        orderService.addFavor(favor);
        return favor;
    }

    @Override
    public Favor save(Favor favor) {
        return favorRepository.save(favor);
    }

    @Override
    public Favor getById(Long id) {
        return favorRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Can't find favor by ID: " + id));
    }
}

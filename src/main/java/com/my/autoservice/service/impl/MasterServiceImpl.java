package com.my.autoservice.service.impl;

import com.my.autoservice.model.Favor;
import com.my.autoservice.model.Master;
import com.my.autoservice.model.PaymentStatus;
import com.my.autoservice.repository.MasterRepository;
import com.my.autoservice.service.MasterService;
import java.math.BigDecimal;
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
        master.setFavors(new ArrayList<>());
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
    public Master addFavor(Favor favor) {
        Master master = favor.getMaster();
        List<Favor> favors = master.getFavors();
        favors.add(favor);
        master.setFavors(favors);
        return save(master);
    }

    @Override
    public BigDecimal getSalary(Long id) {
        return getById(id).getFavors().stream()
                .peek(f -> f.setPaymentStatus(PaymentStatus.PAYED))
                .map(f -> f.getPrice().multiply(BigDecimal.valueOf(0.4)))
                .reduce(BigDecimal::add).orElseThrow(
                        () -> new RuntimeException("Can't get salary for master by Id: " + id));
    }
}

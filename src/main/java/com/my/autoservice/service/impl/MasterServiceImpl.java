package com.my.autoservice.service.impl;

import com.my.autoservice.model.Master;
import com.my.autoservice.repository.MasterRepository;
import com.my.autoservice.service.MasterService;
import org.springframework.stereotype.Service;

@Service
public class MasterServiceImpl implements MasterService {
    private final MasterRepository masterRepository;

    public MasterServiceImpl(MasterRepository masterRepository) {
        this.masterRepository = masterRepository;
    }

    @Override
    public Master save(Master master) {
        return masterRepository.save(master);
    }

    @Override
    public Master getById(Long id) {
        return masterRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Can't get master by Id: " + id));
    }
}

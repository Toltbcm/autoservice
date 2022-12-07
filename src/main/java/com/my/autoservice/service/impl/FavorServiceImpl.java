package com.my.autoservice.service.impl;

import com.my.autoservice.model.Favor;
import com.my.autoservice.repository.FavorRepository;
import com.my.autoservice.service.FavorService;
import org.springframework.stereotype.Service;

@Service
public class FavorServiceImpl implements FavorService {
    private final FavorRepository favorRepository;

    public FavorServiceImpl(FavorRepository favorRepository) {
        this.favorRepository = favorRepository;
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

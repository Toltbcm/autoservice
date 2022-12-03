package com.my.autoservice.service.impl;

import com.my.autoservice.model.Part;
import com.my.autoservice.repository.PartRepository;
import com.my.autoservice.service.PartService;
import org.springframework.stereotype.Service;

@Service
public class PartServiceImpl implements PartService {
    private PartRepository partRepository;

    public PartServiceImpl(PartRepository partRepository) {
        this.partRepository = partRepository;
    }

    @Override
    public Part save(Part part) {
        return partRepository.save(part);
    }

    @Override
    public Part getById(Long id) {
        return partRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Can't find part by ID: " + id));
    }
}

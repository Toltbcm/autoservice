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
}

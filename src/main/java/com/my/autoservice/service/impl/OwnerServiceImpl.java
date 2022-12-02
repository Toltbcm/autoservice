package com.my.autoservice.service.impl;

import com.my.autoservice.model.Car;
import com.my.autoservice.model.Owner;
import com.my.autoservice.repository.OwnerRepository;
import com.my.autoservice.service.OwnerService;
import org.springframework.stereotype.Service;

@Service
public class OwnerServiceImpl implements OwnerService {
    OwnerRepository ownerRepository;

    public OwnerServiceImpl(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    @Override
    public Owner save(Owner owner) {
        return ownerRepository.save(owner);
    }

    @Override
    public Owner addCar(Long id, Car car) {
        Owner owner = getById(id);
        owner.getCars().add(car);
        return ownerRepository.save(owner);
    }

    @Override
    public Owner getById(Long id) {
        return ownerRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Can't find owner by Id: " + id));
    }
}

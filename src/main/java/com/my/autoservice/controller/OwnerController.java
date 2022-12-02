package com.my.autoservice.controller;

import com.my.autoservice.dto.mapper.RequestDtoMapper;
import com.my.autoservice.dto.mapper.ResponseDtoMapper;
import com.my.autoservice.dto.request.OwnerRequestDto;
import com.my.autoservice.dto.response.OwnerResponseDto;
import com.my.autoservice.model.Owner;
import com.my.autoservice.service.OwnerService;
import java.util.ArrayList;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/owner")
public class OwnerController {
    private final OwnerService ownerService;
    private final RequestDtoMapper<OwnerRequestDto, Owner> requestDtoMapper;
    private final ResponseDtoMapper<OwnerResponseDto, Owner> responseDtoMapper;

    public OwnerController(OwnerService ownerService,
            RequestDtoMapper<OwnerRequestDto, Owner> requestDtoMapper,
            ResponseDtoMapper<OwnerResponseDto, Owner> responseDtoMapper) {
        this.ownerService = ownerService;
        this.requestDtoMapper = requestDtoMapper;
        this.responseDtoMapper = responseDtoMapper;
    }

    @PostMapping("/add")
    public OwnerResponseDto create(@RequestBody OwnerRequestDto ownerRequestDto) {
        Owner owner = requestDtoMapper.mapToModel(ownerRequestDto);
        owner.setCars(new ArrayList<>());
        owner.setOrders(new ArrayList<>());
        return responseDtoMapper.mapToDto(ownerService.save(owner));
    }

    @PutMapping("/update//{id}")
    public OwnerResponseDto update(@PathVariable Long id,
            @RequestBody OwnerRequestDto ownerRequestDto) {
        Owner ownerFromDb = ownerService.getById(id);
        Owner owner = requestDtoMapper.mapToModel(ownerRequestDto);
        owner.setId(id);
        owner.setCars(ownerFromDb.getCars());
        owner.setOrders(ownerFromDb.getOrders());
        return responseDtoMapper.mapToDto(ownerService.save(owner));
    }
}

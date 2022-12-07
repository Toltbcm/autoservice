package com.my.autoservice.controller;

import com.my.autoservice.dto.mapper.OrderMapper;
import com.my.autoservice.dto.mapper.RequestDtoMapper;
import com.my.autoservice.dto.mapper.ResponseDtoMapper;
import com.my.autoservice.dto.request.OwnerRequestDto;
import com.my.autoservice.dto.response.OrderResponseDto;
import com.my.autoservice.dto.response.OwnerResponseDto;
import com.my.autoservice.model.Owner;
import com.my.autoservice.service.OwnerService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.GetMapping;
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
    private final OrderMapper orderMapper;
    private final RequestDtoMapper<OwnerRequestDto, Owner> requestDtoMapper;
    private final ResponseDtoMapper<OwnerResponseDto, Owner> responseDtoMapper;

    public OwnerController(OwnerService ownerService,
            OrderMapper orderMapper, RequestDtoMapper<OwnerRequestDto, Owner> requestDtoMapper,
            ResponseDtoMapper<OwnerResponseDto, Owner> responseDtoMapper) {
        this.ownerService = ownerService;
        this.orderMapper = orderMapper;
        this.requestDtoMapper = requestDtoMapper;
        this.responseDtoMapper = responseDtoMapper;
    }

    @PostMapping("/add")
    public OwnerResponseDto create(@RequestBody OwnerRequestDto ownerRequestDto) {
        Owner owner = requestDtoMapper.mapToModel(ownerRequestDto);
        return responseDtoMapper.mapToDto(ownerService.create(owner));
    }

    @PutMapping("/update//{ownerId}")
    public OwnerResponseDto update(@PathVariable Long ownerId,
            @RequestBody OwnerRequestDto ownerRequestDto) {
        Owner ownerFromDb = ownerService.getById(ownerId);
        Owner owner = requestDtoMapper.mapToModel(ownerRequestDto);
        owner.setId(ownerId);
        owner.setCars(ownerFromDb.getCars());
        owner.setOrders(ownerFromDb.getOrders());
        return responseDtoMapper.mapToDto(ownerService.save(owner));
    }

    @GetMapping("/order//{ownerId}")
    public List<OrderResponseDto> getOrders(@PathVariable Long ownerId) {
        return ownerService.getById(ownerId).getOrders().stream()
                .map(orderMapper::mapToDto)
                .collect(Collectors.toList());
    }
}

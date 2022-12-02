package com.my.autoservice.controller;

import com.my.autoservice.dto.mapper.OrderMapper;
import com.my.autoservice.dto.mapper.OwnerMapper;
import com.my.autoservice.dto.request.OwnerCreateDto;
import com.my.autoservice.dto.request.OwnerRequestDto;
import com.my.autoservice.dto.response.OwnerResponseDto;
import com.my.autoservice.model.Owner;
import com.my.autoservice.service.OrderService;
import com.my.autoservice.service.OwnerService;
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
    private final OwnerMapper ownerMapper;
    private final OrderService orderService;
    private final OrderMapper orderMapper;

    public OwnerController(OwnerService ownerService,
            OwnerMapper ownerMapper,
            OrderService orderService,
            OrderMapper orderMapper) {
        this.ownerService = ownerService;
        this.ownerMapper = ownerMapper;
        this.orderService = orderService;
        this.orderMapper = orderMapper;
    }

    @PostMapping("/add")
    public OwnerResponseDto create(@RequestBody OwnerCreateDto ownerCreateDto) {
        return ownerMapper.mapToDto(ownerService.create(ownerCreateDto));
    }

    @PutMapping("/update//{id}")
    public OwnerResponseDto update(@PathVariable Long id,
            @RequestBody OwnerRequestDto ownerRequestDto) {
        Owner owner = ownerMapper.mapToModel(ownerRequestDto);
        owner.setId(id);
        return ownerMapper.mapToDto(ownerService.save(owner));
    }

//    @GetMapping("/order//{id}")
//    public List<OrderResponseDto> getOrders(@PathVariable Long id) {
//        return orderService.getAllByOwnerId(id).stream()
//                .map(orderMapper::mapToDto)
//                .collect(Collectors.toList());
//    }
}
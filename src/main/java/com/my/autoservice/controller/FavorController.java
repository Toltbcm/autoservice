package com.my.autoservice.controller;

import com.my.autoservice.dto.mapper.FavorMapper;
import com.my.autoservice.dto.mapper.RequestDtoMapper;
import com.my.autoservice.dto.mapper.ResponseDtoMapper;
import com.my.autoservice.dto.request.FavorRequestDto;
import com.my.autoservice.dto.response.FavorResponseDto;
import com.my.autoservice.model.Favor;
import com.my.autoservice.model.PaymentStatus;
import com.my.autoservice.service.FavorService;
import com.my.autoservice.service.MasterService;
import com.my.autoservice.service.OrderService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/service")
public class FavorController {
    private final FavorService favorService;
    private final FavorMapper favorMapper;
    private final MasterService masterService;
    private final OrderService orderService;
    private final RequestDtoMapper<FavorRequestDto, Favor> requestDtoMapper;
    private final ResponseDtoMapper<FavorResponseDto, Favor> responseDtoMapper;

    public FavorController(FavorService favorService,
            FavorMapper favorMapper,
            MasterService masterService,
            OrderService orderService,
            RequestDtoMapper<FavorRequestDto, Favor> requestDtoMapper,
            ResponseDtoMapper<FavorResponseDto, Favor> responseDtoMapper) {
        this.favorService = favorService;
        this.favorMapper = favorMapper;
        this.masterService = masterService;
        this.orderService = orderService;
        this.requestDtoMapper = requestDtoMapper;
        this.responseDtoMapper = responseDtoMapper;
    }

    @PostMapping("/add")
    FavorResponseDto create(@RequestBody FavorRequestDto favorRequestDto) {
        Favor favor = requestDtoMapper.mapToModel(favorRequestDto);
        favor = favorService.save(favor);
        masterService.addFavor(favor);
        orderService.addFavor(favor);
        return responseDtoMapper.mapToDto(favor);
    }

    @PutMapping("/update//{favorId}")
    FavorResponseDto create(@PathVariable Long favorId,
            @RequestBody FavorRequestDto favorRequestDto) {
        Favor favor = requestDtoMapper.mapToModel(favorRequestDto);
        favor.setId(favorId);
        return responseDtoMapper.mapToDto(favorService.save(favor));
    }

    @PutMapping("/{favorId}/status//{favorStatus}")
    public FavorResponseDto changeStatus(@PathVariable Long favorId,
            @PathVariable String favorStatus) {
        Favor favor = favorService.getById(favorId);
        favor.setPaymentStatus(PaymentStatus.valueOf(favorStatus.toUpperCase()));
        return responseDtoMapper.mapToDto(favorService.save(favor));
    }
}

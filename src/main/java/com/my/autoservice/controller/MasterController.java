package com.my.autoservice.controller;

import com.my.autoservice.dto.mapper.RequestDtoMapper;
import com.my.autoservice.dto.mapper.ResponseDtoMapper;
import com.my.autoservice.dto.request.MasterRequestDto;
import com.my.autoservice.dto.response.MasterResponseDto;
import com.my.autoservice.model.Master;
import com.my.autoservice.service.MasterService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/master")
public class MasterController {
    private final MasterService masterService;
    private final RequestDtoMapper<MasterRequestDto, Master> requestDtoMapper;
    private final ResponseDtoMapper<MasterResponseDto, Master> responseDtoMapper;

    public MasterController(MasterService masterService,
            RequestDtoMapper<MasterRequestDto, Master> requestDtoMapper,
            ResponseDtoMapper<MasterResponseDto, Master> responseDtoMapper) {
        this.masterService = masterService;
        this.requestDtoMapper = requestDtoMapper;
        this.responseDtoMapper = responseDtoMapper;
    }

    @PostMapping("/add")
    public MasterResponseDto create(@RequestBody MasterRequestDto masterRequestDto) {
        Master master = requestDtoMapper.mapToModel(masterRequestDto);
        return responseDtoMapper.mapToDto(masterService.create(master));
    }

    @PutMapping("/update//{id}")
    public MasterResponseDto update(@PathVariable Long id,
            @RequestBody MasterRequestDto masterRequestDto) {
        Master masterFromDb = masterService.getById(id);
        Master master = requestDtoMapper.mapToModel(masterRequestDto);
        master.setId(id);
        master.setOrders(masterFromDb.getOrders());
        return responseDtoMapper.mapToDto(masterService.save(master));
    }
}

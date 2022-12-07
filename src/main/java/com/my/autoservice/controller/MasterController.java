package com.my.autoservice.controller;

import com.my.autoservice.dto.mapper.FavorMapper;
import com.my.autoservice.dto.mapper.RequestDtoMapper;
import com.my.autoservice.dto.mapper.ResponseDtoMapper;
import com.my.autoservice.dto.request.MasterRequestDto;
import com.my.autoservice.dto.response.FavorResponseDto;
import com.my.autoservice.dto.response.MasterResponseDto;
import com.my.autoservice.model.Master;
import com.my.autoservice.service.MasterService;
import java.math.BigDecimal;
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
@RequestMapping("/master")
public class MasterController {
    private final MasterService masterService;
    private final FavorMapper favorMapper;
    private final RequestDtoMapper<MasterRequestDto, Master> requestDtoMapper;
    private final ResponseDtoMapper<MasterResponseDto, Master> responseDtoMapper;

    public MasterController(MasterService masterService,
            FavorMapper favorMapper, RequestDtoMapper<MasterRequestDto, Master> requestDtoMapper,
            ResponseDtoMapper<MasterResponseDto, Master> responseDtoMapper) {
        this.masterService = masterService;
        this.favorMapper = favorMapper;
        this.requestDtoMapper = requestDtoMapper;
        this.responseDtoMapper = responseDtoMapper;
    }

    @PostMapping("/add")
    public MasterResponseDto create(@RequestBody MasterRequestDto masterRequestDto) {
        Master master = requestDtoMapper.mapToModel(masterRequestDto);
        return responseDtoMapper.mapToDto(masterService.create(master));
    }

    @PutMapping("/update//{masterId}")
    public MasterResponseDto update(@PathVariable Long masterId,
            @RequestBody MasterRequestDto masterRequestDto) {
        Master masterFromDb = masterService.getById(masterId);
        Master master = requestDtoMapper.mapToModel(masterRequestDto);
        master.setId(masterId);
        master.setFavors(masterFromDb.getFavors());
        return responseDtoMapper.mapToDto(masterService.save(master));
    }

    @GetMapping("/order//{masterId}")
    public List<FavorResponseDto> getFavors(@PathVariable Long masterId) {
        return masterService.getById(masterId).getFavors().stream()
                .map(favorMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/salary//{masterId}")
    public BigDecimal getSalary(@PathVariable Long masterId) {
        return masterService.getSalary(masterId);
    }
}

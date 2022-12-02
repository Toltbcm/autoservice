package com.my.autoservice.controller;

import com.my.autoservice.dto.mapper.RequestDtoMapper;
import com.my.autoservice.dto.mapper.ResponseDtoMapper;
import com.my.autoservice.dto.request.PartRequestDto;
import com.my.autoservice.dto.response.PartResponseDto;
import com.my.autoservice.model.Part;
import com.my.autoservice.service.PartService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/part")
public class PartController {
    private final PartService partService;
    private final RequestDtoMapper<PartRequestDto, Part> requestDtoMapper;
    private final ResponseDtoMapper<PartResponseDto, Part> responseDtoMapper;

    public PartController(PartService partService,
            RequestDtoMapper<PartRequestDto, Part> requestDtoMapper,
            ResponseDtoMapper<PartResponseDto, Part> responseDtoMapper) {
        this.partService = partService;
        this.requestDtoMapper = requestDtoMapper;
        this.responseDtoMapper = responseDtoMapper;
    }

    @PostMapping("/add")
    public PartResponseDto addPart(@RequestBody PartRequestDto partRequestDto) {
        Part part = requestDtoMapper.mapToModel(partRequestDto);
        return responseDtoMapper.mapToDto(partService.save(part));
    }

    @PutMapping("/update//{id}")
    public PartResponseDto updatePart(@PathVariable Long id,
            @RequestBody PartRequestDto partRequestDto) {
        Part part = requestDtoMapper.mapToModel(partRequestDto);
        part.setId(id);
        return responseDtoMapper.mapToDto(partService.save(part));
    }
}

package com.my.autoservice.dto.mapper;

import com.my.autoservice.dto.request.PartRequestDto;
import com.my.autoservice.dto.response.PartResponseDto;
import com.my.autoservice.model.Part;
import org.springframework.stereotype.Component;

@Component
public class PartMapper implements RequestDtoMapper<PartRequestDto, Part>,
        ResponseDtoMapper<PartResponseDto, Part> {
    @Override
    public Part mapToModel(PartRequestDto dto) {
        Part part = new Part();
        part.setTitle(dto.getTitle());
        part.setPrice(dto.getPrice());
        return part;
    }

    @Override
    public PartResponseDto mapToDto(Part part) {
        PartResponseDto dto = new PartResponseDto();
        dto.setId(part.getId());
        dto.setTitle(part.getTitle());
        dto.setPrice(part.getPrice());
        return dto;
    }
}

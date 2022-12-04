package com.my.autoservice.dto.mapper;

import com.my.autoservice.dto.request.MasterRequestDto;
import com.my.autoservice.dto.response.MasterResponseDto;
import com.my.autoservice.model.Favor;
import com.my.autoservice.model.Master;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class MasterMapper implements RequestDtoMapper<MasterRequestDto, Master>,
        ResponseDtoMapper<MasterResponseDto, Master> {

    @Override
    public Master mapToModel(MasterRequestDto dto) {
        Master master = new Master();
        master.setFirstName(dto.getFirstName());
        master.setLastName(dto.getLastName());
        master.setPatronymic(dto.getPatronymic());
        return master;
    }

    @Override
    public MasterResponseDto mapToDto(Master master) {
        MasterResponseDto dto = new MasterResponseDto();
        dto.setId(master.getId());
        dto.setFirstName(master.getFirstName());
        dto.setLastName(master.getLastName());
        dto.setPatronymic(master.getPatronymic());
        dto.setFavorIds(master.getFavors().stream()
                .map(Favor::getId)
                .collect(Collectors.toList()));
        return dto;
    }
}

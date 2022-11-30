package com.my.autoservice.dto.mapper;

public interface RequestDtoMapper<D, M> {
    M mapToModel(D dto);
}

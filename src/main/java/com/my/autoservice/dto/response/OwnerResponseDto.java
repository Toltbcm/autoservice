package com.my.autoservice.dto.response;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OwnerResponseDto {
    Long id;
    List<Long> carIds;
    List<Long> orderIds;
}

package com.my.autoservice.dto.response;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OwnerResponseDto {
    private Long id;
    private String licenseNumber;
    private List<Long> carIds;
    private List<Long> orderIds;
}

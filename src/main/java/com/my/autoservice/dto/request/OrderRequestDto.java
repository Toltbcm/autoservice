package com.my.autoservice.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderRequestDto {
    private Long carId;
    private String problemDescription;
}

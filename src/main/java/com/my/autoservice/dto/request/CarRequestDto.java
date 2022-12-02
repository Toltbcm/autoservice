package com.my.autoservice.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CarRequestDto {
    private String manufacturer;
    private String model;
    private Integer productionYear;
    private String serialNumber;
    private Long ownerId;
}

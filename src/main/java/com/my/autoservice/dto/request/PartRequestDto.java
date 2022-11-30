package com.my.autoservice.dto.request;

import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PartRequestDto {
    private String title;
    private BigDecimal price;
}

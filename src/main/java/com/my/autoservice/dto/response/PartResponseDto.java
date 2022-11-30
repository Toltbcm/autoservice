package com.my.autoservice.dto.response;

import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PartResponseDto {
    private Long id;
    private String title;
    private BigDecimal price;
}

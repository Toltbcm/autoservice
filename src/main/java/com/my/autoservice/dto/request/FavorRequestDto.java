package com.my.autoservice.dto.request;

import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FavorRequestDto {
    private Long orderId;
    private Long masterId;
    private BigDecimal price;
    private String paymentStatus;
}

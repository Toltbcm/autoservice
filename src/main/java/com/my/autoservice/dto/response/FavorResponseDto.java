package com.my.autoservice.dto.response;

import com.my.autoservice.model.PaymentStatus;
import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FavorResponseDto {
    private Long id;
    private Long orderId;
    private Long masterId;
    private String description;
    private BigDecimal price;
    private PaymentStatus paymentStatus;
}

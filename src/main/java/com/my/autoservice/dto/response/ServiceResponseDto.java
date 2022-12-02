package com.my.autoservice.dto.response;

import com.my.autoservice.model.Master;
import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ServiceResponseDto {
    private Long id;
    private Long orderId;
    private Master master;
    private BigDecimal price;
    private String paymentStatus;
}

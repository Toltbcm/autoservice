package com.my.autoservice.dto.response;

import com.my.autoservice.model.OrderStatus;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderResponseDto {
    private Long id;
    private Long carId;
    private String problemDescription;
    private LocalDateTime startTime;
    private List<Long> favorsId;
    private List<Long> partIds;
    private OrderStatus status;
    private BigDecimal totalPrice;
    private LocalDateTime finishTime;

}

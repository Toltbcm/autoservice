package com.my.autoservice.dto.response;

import com.my.autoservice.model.Car;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderResponseDto {
    private Long id;
    private Car car;
    private String problemDescription;
    private LocalDateTime startTime;
    private List<Long> serviceIds;
    private List<Long> partIds;
    private String status;
    private BigDecimal totalPrice;
    private LocalDateTime finishTime;

}

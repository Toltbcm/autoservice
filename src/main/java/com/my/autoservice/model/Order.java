package com.my.autoservice.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "orders")
public class Order {
    @Id
    private Long id;
    @ManyToOne
    @JoinColumn(name = "car_id")
    private Car car;
    private String problemDescription;
    private LocalDateTime startTime;
    @OneToMany
    private List<Service> services;
    @OneToMany
    private List<Part> parts;
    private OrderStatus status;
    private BigDecimal totalPrice;
    private LocalDateTime finishTime;
}

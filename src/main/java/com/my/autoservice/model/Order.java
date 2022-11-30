package com.my.autoservice.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
@Table(name = "orders")
public class Order {
    @Id
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "car_id")
    private Car car;
    private String problemDescription;
    private LocalDateTime startTime;
    @OneToMany(mappedBy = "order")
    private List<Service> services;
    @ManyToMany
    @JoinTable(inverseJoinColumns = @JoinColumn(name = "part_id"))
    private List<Part> parts;
    @Enumerated(EnumType.STRING)
    private OrderStatus status;
    private BigDecimal totalPrice;
    private LocalDateTime finishTime;
}

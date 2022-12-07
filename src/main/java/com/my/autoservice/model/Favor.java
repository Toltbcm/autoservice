package com.my.autoservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "favors")
public class Favor {
    @Id
    @GeneratedValue(generator = "favors_id_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "favors_id_seq", sequenceName = "favors_id_seq", allocationSize = 1)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;
    @OneToOne(fetch = FetchType.LAZY)
    private Master master;
    private String description;
    private BigDecimal price;
    @Enumerated(EnumType.STRING)
    private PaymentStatus paymentStatus;
}

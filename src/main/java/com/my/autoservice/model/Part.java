package com.my.autoservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name = "parts")
public class Part {
    @Id
    @GeneratedValue(generator = "parts_id_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "parts_id_seq", sequenceName = "parts_id_seq", allocationSize = 1)
    private Long id;
    private String title;
    private BigDecimal price;
}

package com.my.autoservice.model;

import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
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

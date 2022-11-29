package com.my.autoservice.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
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
@AllArgsConstructor
@Table(name = "cars")
public class Car {
    @Id
    @GeneratedValue(generator = "cars_id_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "cars_id_seq", sequenceName = "cars_id_seq", allocationSize = 1)
    private Long id;
    private String manufacturer;
    private String model;
    private Integer productionYear;
    private String serialNumber;
    @ManyToOne
    private Owner owner;
}

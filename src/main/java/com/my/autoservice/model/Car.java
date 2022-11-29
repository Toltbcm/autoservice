package com.my.autoservice.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
    private Long id;
    private String manufacturer;
    private String model;
    private Integer productionYear;
    private String serialNumber;
    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Owner owner;
}

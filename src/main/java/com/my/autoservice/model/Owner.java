package com.my.autoservice.model;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
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
@Table(name = "owners")
public class Owner {
    @Id
    @GeneratedValue(generator = "owners_id_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "owners_id_seq", sequenceName = "owners_id_seq", allocationSize = 1)
    Long id;
    @OneToMany(mappedBy = "owner")
    List<Car> cars;
    @OneToMany
    @JoinColumn(name = "owner_id")
    List<Order> orders;
}

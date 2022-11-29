package com.my.autoservice.model;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@AllArgsConstructor
@Table(name = "masters")
public class Master {
    @Id
    @GeneratedValue(generator = "masters_id_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "masters_id_seq", sequenceName = "masters_id_seq", allocationSize = 1)
    private Long id;
    private String firstName;
    private String lastName;
    private String patronymic;
    @OneToMany
    private List<Order> completedOrders;
}

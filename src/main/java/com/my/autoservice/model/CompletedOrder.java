package com.my.autoservice.model;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "masters")
public class CompletedOrder {
    @Id
//    @GeneratedValue(generator = "masters_id_seq", strategy = GenerationType.SEQUENCE)
//    @SequenceGenerator(name = "masters_id_seq", sequenceName = "masters_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
//    @ManyToMany
//    private List<Order> orders;
}

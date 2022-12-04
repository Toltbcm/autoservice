package com.my.autoservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
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
    @JoinColumn(name = "master_id")
    private List<Favor> favors;
}

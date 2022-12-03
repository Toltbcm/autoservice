package com.my.autoservice.repository;

import com.my.autoservice.model.Car;
import com.my.autoservice.model.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OwnerRepository extends JpaRepository<Owner, Long> {
    public Owner findOwnerByCarsId(Long id);
}

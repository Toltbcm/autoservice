package com.my.autoservice.repository;

import com.my.autoservice.model.Favor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FavorRepository extends JpaRepository<Favor, Long> {
}

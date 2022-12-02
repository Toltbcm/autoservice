package com.my.autoservice.repository;

import com.my.autoservice.model.Order;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
//    List<Order> getAllByMasterId(Long id);
//    @Query("SELECT o FROM Order o JOIN Master m JOIN Owner ow WHERE ow.id IN m.completedOrders")
//    List<Order> findAllByOwnerId(Long id);
}

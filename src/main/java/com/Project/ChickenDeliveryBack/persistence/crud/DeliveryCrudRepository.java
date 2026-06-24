package com.Project.ChickenDeliveryBack.persistence.crud;

import com.Project.ChickenDeliveryBack.persistence.entity.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DeliveryCrudRepository extends JpaRepository<Delivery, Integer> {
    Optional<Delivery> findByVenta_Id(Integer idVenta);
}

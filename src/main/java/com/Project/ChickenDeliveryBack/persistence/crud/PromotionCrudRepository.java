package com.Project.ChickenDeliveryBack.persistence.crud;

import com.Project.ChickenDeliveryBack.persistence.entity.Promotion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PromotionCrudRepository extends JpaRepository<Promotion, Integer> {
    Optional<Promotion> findByCodigo(String codigo);
    List<Promotion> findByEstado(Boolean estado);
}

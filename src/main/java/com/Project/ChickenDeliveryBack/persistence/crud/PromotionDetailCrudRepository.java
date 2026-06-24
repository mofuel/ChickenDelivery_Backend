package com.Project.ChickenDeliveryBack.persistence.crud;

import com.Project.ChickenDeliveryBack.persistence.entity.PromotionDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PromotionDetailCrudRepository extends JpaRepository<PromotionDetail, Integer> {
    List<PromotionDetail> findByVenta_Id(Integer idVenta);
    List<PromotionDetail> findByPromocion_Id(Integer idPromocion);
}

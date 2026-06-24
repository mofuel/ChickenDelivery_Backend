package com.Project.ChickenDeliveryBack.domain.repository;

import com.Project.ChickenDeliveryBack.domain.dto.PromotionDetailDTO;

import java.util.List;
import java.util.Optional;

public interface PromotionDetailRepository {
    PromotionDetailDTO save(PromotionDetailDTO promotionDetailDTO);
    Optional<PromotionDetailDTO> findById(Integer id);
    List<PromotionDetailDTO> findAll();
    List<PromotionDetailDTO> findByVentaId(Integer idVenta);
    List<PromotionDetailDTO> findByPromocionId(Integer idPromocion);
    void deleteById(Integer id);
}

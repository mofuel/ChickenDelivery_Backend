package com.Project.ChickenDeliveryBack.domain.repository;

import com.Project.ChickenDeliveryBack.domain.dto.PromotionDTO;

import java.util.List;
import java.util.Optional;

public interface PromotionRepository {
    PromotionDTO save(PromotionDTO promotionDTO);
    Optional<PromotionDTO> findById(Integer id);
    List<PromotionDTO> findAll();
    Optional<PromotionDTO> findByCodigo(String codigo);
    List<PromotionDTO> findByEstado(Boolean estado);
    void deleteById(Integer id);
}

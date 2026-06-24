package com.Project.ChickenDeliveryBack.domain.service;

import com.Project.ChickenDeliveryBack.domain.dto.PromotionDetailDTO;
import com.Project.ChickenDeliveryBack.domain.repository.PromotionDetailRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PromotionDetailService {

    private final PromotionDetailRepository promotionDetailRepository;

    public PromotionDetailService(PromotionDetailRepository promotionDetailRepository) {
        this.promotionDetailRepository = promotionDetailRepository;
    }

    public PromotionDetailDTO save(PromotionDetailDTO dto) {
        if (dto.getCantidad() == null || dto.getCantidad() <= 0) {
            throw new IllegalArgumentException("La cantidad debe ser mayor a 0");
        }
        if (dto.getPrecioUnitario() == null) {
            throw new IllegalArgumentException("El precio unitario es obligatorio");
        }
        if (dto.getSubtotal() == null) {
            dto.setSubtotal(dto.getPrecioUnitario().multiply(java.math.BigDecimal.valueOf(dto.getCantidad())));
        }
        return promotionDetailRepository.save(dto);
    }

    public Optional<PromotionDetailDTO> findById(Integer id) {
        return promotionDetailRepository.findById(id);
    }

    public List<PromotionDetailDTO> findAll() {
        return promotionDetailRepository.findAll();
    }

    public List<PromotionDetailDTO> findByVentaId(Integer idVenta) {
        return promotionDetailRepository.findByVentaId(idVenta);
    }

    public List<PromotionDetailDTO> findByPromocionId(Integer idPromocion) {
        return promotionDetailRepository.findByPromocionId(idPromocion);
    }

    public void deleteById(Integer id) {
        promotionDetailRepository.deleteById(id);
    }
}

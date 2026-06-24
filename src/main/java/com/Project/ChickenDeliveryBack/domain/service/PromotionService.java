package com.Project.ChickenDeliveryBack.domain.service;

import com.Project.ChickenDeliveryBack.domain.dto.PromotionDTO;
import com.Project.ChickenDeliveryBack.domain.repository.PromotionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PromotionService {

    private final PromotionRepository promotionRepository;

    public PromotionService(PromotionRepository promotionRepository) {
        this.promotionRepository = promotionRepository;
    }

    public PromotionDTO save(PromotionDTO dto) {
        if (dto.getCodigo() == null || dto.getCodigo().isBlank()) {
            throw new IllegalArgumentException("El código de la promoción es obligatorio");
        }
        if (dto.getNombre() == null || dto.getNombre().isBlank()) {
            throw new IllegalArgumentException("El nombre de la promoción es obligatorio");
        }
        if (dto.getPrecioCombo() == null || dto.getPrecioCombo().compareTo(java.math.BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("El precio combo debe ser mayor o igual a 0");
        }
        if (dto.getFechaInicio() == null || dto.getFechaFin() == null) {
            throw new IllegalArgumentException("Las fechas de inicio y fin son obligatorias");
        }
        if (dto.getFechaFin().isBefore(dto.getFechaInicio())) {
            throw new IllegalArgumentException("La fecha fin no puede ser anterior a la fecha inicio");
        }
        dto.setCodigo(dto.getCodigo().trim().toUpperCase());
        if (promotionRepository.findByCodigo(dto.getCodigo()).isPresent()) {
            throw new IllegalArgumentException("Ya existe una promoción con ese código");
        }
        if (dto.getEstado() == null) {
            dto.setEstado(true);
        }
        return promotionRepository.save(dto);
    }

    public Optional<PromotionDTO> findById(Integer id) {
        return promotionRepository.findById(id);
    }

    public List<PromotionDTO> findAll() {
        return promotionRepository.findAll();
    }

    public Optional<PromotionDTO> findByCodigo(String codigo) {
        return promotionRepository.findByCodigo(codigo);
    }

    public List<PromotionDTO> findByEstado(Boolean estado) {
        return promotionRepository.findByEstado(estado);
    }

    public void deleteById(Integer id) {
        promotionRepository.deleteById(id);
    }
}

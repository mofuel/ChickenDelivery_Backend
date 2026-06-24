package com.Project.ChickenDeliveryBack.domain.service;

import com.Project.ChickenDeliveryBack.domain.dto.SaleDetailDTO;
import com.Project.ChickenDeliveryBack.domain.repository.SaleDetailRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SaleDetailService {

    private final SaleDetailRepository saleDetailRepository;

    public SaleDetailService(SaleDetailRepository saleDetailRepository) {
        this.saleDetailRepository = saleDetailRepository;
    }

    public SaleDetailDTO save(SaleDetailDTO dto) {
        if (dto.getCantidad() == null || dto.getCantidad() <= 0) {
            throw new IllegalArgumentException("La cantidad debe ser mayor a 0");
        }
        if (dto.getPrecioUnitario() == null) {
            throw new IllegalArgumentException("El precio unitario es obligatorio");
        }
        if (dto.getSubtotal() == null) {
            dto.setSubtotal(dto.getPrecioUnitario().multiply(java.math.BigDecimal.valueOf(dto.getCantidad())));
        }
        return saleDetailRepository.save(dto);
    }

    public Optional<SaleDetailDTO> findById(Integer id) {
        return saleDetailRepository.findById(id);
    }

    public List<SaleDetailDTO> findAll() {
        return saleDetailRepository.findAll();
    }

    public List<SaleDetailDTO> findByVentaId(Integer idVenta) {
        return saleDetailRepository.findByVentaId(idVenta);
    }

    public List<SaleDetailDTO> findByProductoId(Integer idProducto) {
        return saleDetailRepository.findByProductoId(idProducto);
    }

    public void deleteById(Integer id) {
        saleDetailRepository.deleteById(id);
    }
}

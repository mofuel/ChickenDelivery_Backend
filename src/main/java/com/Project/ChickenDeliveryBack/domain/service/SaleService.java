package com.Project.ChickenDeliveryBack.domain.service;

import com.Project.ChickenDeliveryBack.domain.dto.SaleDTO;
import com.Project.ChickenDeliveryBack.domain.repository.SaleRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class SaleService {

    private final SaleRepository saleRepository;

    public SaleService(SaleRepository saleRepository) {
        this.saleRepository = saleRepository;
    }

    public SaleDTO save(SaleDTO dto) {
        if (dto.getTipoEntrega() == null || dto.getTipoEntrega().isBlank()) {
            throw new IllegalArgumentException("El tipo de entrega es obligatorio");
        }
        if (dto.getMetodoPago() == null || dto.getMetodoPago().isBlank()) {
            throw new IllegalArgumentException("El método de pago es obligatorio");
        }
        if (dto.getCanalVenta() == null || dto.getCanalVenta().isBlank()) {
            throw new IllegalArgumentException("El canal de venta es obligatorio");
        }
        if (dto.getTotal() == null || dto.getTotal().compareTo(java.math.BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("El total debe ser mayor o igual a 0");
        }
        if (dto.getFechaVenta() == null) {
            dto.setFechaVenta(LocalDateTime.now());
        }
        return saleRepository.save(dto);
    }

    public Optional<SaleDTO> findById(Integer id) {
        return saleRepository.findById(id);
    }

    public List<SaleDTO> findAll() {
        return saleRepository.findAll();
    }

    public List<SaleDTO> findByUsuarioId(Integer idUsuario) {
        return saleRepository.findByUsuarioId(idUsuario);
    }

    public List<SaleDTO> findByClienteId(Integer idCliente) {
        return saleRepository.findByClienteId(idCliente);
    }

    public List<SaleDTO> findByFechaVentaBetween(LocalDateTime start, LocalDateTime end) {
        if (start == null || end == null) {
            throw new IllegalArgumentException("Las fechas de inicio y fin son obligatorias");
        }
        if (end.isBefore(start)) {
            throw new IllegalArgumentException("La fecha fin no puede ser anterior a la fecha inicio");
        }
        return saleRepository.findByFechaVentaBetween(start, end);
    }

    public void deleteById(Integer id) {
        saleRepository.deleteById(id);
    }
}

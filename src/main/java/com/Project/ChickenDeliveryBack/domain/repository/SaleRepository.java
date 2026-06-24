package com.Project.ChickenDeliveryBack.domain.repository;

import com.Project.ChickenDeliveryBack.domain.dto.SaleDTO;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface SaleRepository {
    SaleDTO save(SaleDTO saleDTO);
    Optional<SaleDTO> findById(Integer id);
    List<SaleDTO> findAll();
    List<SaleDTO> findByUsuarioId(Integer idUsuario);
    List<SaleDTO> findByClienteId(Integer idCliente);
    List<SaleDTO> findByFechaVentaBetween(LocalDateTime start, LocalDateTime end);
    void deleteById(Integer id);
}

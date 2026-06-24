package com.Project.ChickenDeliveryBack.domain.repository;

import com.Project.ChickenDeliveryBack.domain.dto.SaleDetailDTO;

import java.util.List;
import java.util.Optional;

public interface SaleDetailRepository {
    SaleDetailDTO save(SaleDetailDTO saleDetailDTO);
    Optional<SaleDetailDTO> findById(Integer id);
    List<SaleDetailDTO> findAll();
    List<SaleDetailDTO> findByVentaId(Integer idVenta);
    List<SaleDetailDTO> findByProductoId(Integer idProducto);
    void deleteById(Integer id);
}

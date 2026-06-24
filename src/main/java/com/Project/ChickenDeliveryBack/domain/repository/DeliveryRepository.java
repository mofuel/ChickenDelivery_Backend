package com.Project.ChickenDeliveryBack.domain.repository;

import com.Project.ChickenDeliveryBack.domain.dto.DeliveryDTO;

import java.util.List;
import java.util.Optional;

public interface DeliveryRepository {
    DeliveryDTO save(DeliveryDTO deliveryDTO);
    Optional<DeliveryDTO> findById(Integer id);
    List<DeliveryDTO> findAll();
    Optional<DeliveryDTO> findByVentaId(Integer idVenta);
    void deleteById(Integer id);
}

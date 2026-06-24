package com.Project.ChickenDeliveryBack.domain.service;

import com.Project.ChickenDeliveryBack.domain.dto.DeliveryDTO;
import com.Project.ChickenDeliveryBack.domain.repository.DeliveryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeliveryService {

    private final DeliveryRepository deliveryRepository;

    public DeliveryService(DeliveryRepository deliveryRepository) {
        this.deliveryRepository = deliveryRepository;
    }

    public DeliveryDTO save(DeliveryDTO dto) {
        if (dto.getEstadoDelivery() == null || dto.getEstadoDelivery().isBlank()) {
            throw new IllegalArgumentException("El estado del delivery es obligatorio");
        }
        if (dto.getCostoDelivery() == null) {
            throw new IllegalArgumentException("El costo del delivery es obligatorio");
        }
        return deliveryRepository.save(dto);
    }

    public Optional<DeliveryDTO> findById(Integer id) {
        return deliveryRepository.findById(id);
    }

    public List<DeliveryDTO> findAll() {
        return deliveryRepository.findAll();
    }

    public Optional<DeliveryDTO> findByVentaId(Integer idVenta) {
        return deliveryRepository.findByVentaId(idVenta);
    }

    public void deleteById(Integer id) {
        deliveryRepository.deleteById(id);
    }
}

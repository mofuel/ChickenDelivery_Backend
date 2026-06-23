package com.Project.ChickenDeliveryBack.persistence.mapper;

import com.Project.ChickenDeliveryBack.domain.dto.DeliveryDTO;
import com.Project.ChickenDeliveryBack.persistence.entity.Delivery;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface DeliveryMapper {

    @Mapping(target = "idVenta", source = "venta.id")
    DeliveryDTO toDto(Delivery delivery);

    @Mapping(target = "venta", ignore = true)
    Delivery toEntity(DeliveryDTO deliveryDTO);
}

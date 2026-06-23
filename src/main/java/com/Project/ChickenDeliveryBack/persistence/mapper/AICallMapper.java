package com.Project.ChickenDeliveryBack.persistence.mapper;

import com.Project.ChickenDeliveryBack.domain.dto.AICallDTO;
import com.Project.ChickenDeliveryBack.persistence.entity.AICall;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AICallMapper {

    @Mapping(target = "idVenta", source = "venta.id")
    AICallDTO toDto(AICall aiCall);

    @Mapping(target = "venta", ignore = true)
    AICall toEntity(AICallDTO aiCallDTO);
}

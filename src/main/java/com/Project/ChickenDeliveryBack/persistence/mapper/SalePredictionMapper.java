package com.Project.ChickenDeliveryBack.persistence.mapper;

import com.Project.ChickenDeliveryBack.domain.dto.SalePredictionDTO;
import com.Project.ChickenDeliveryBack.persistence.entity.SalePrediction;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SalePredictionMapper {

    @Mapping(target = "idUsuario", source = "usuario.id")
    @Mapping(target = "nombreUsuario", source = "usuario.nombre")
    SalePredictionDTO toDto(SalePrediction salePrediction);

    @Mapping(target = "usuario", ignore = true)
    SalePrediction toEntity(SalePredictionDTO salePredictionDTO);
}

package com.Project.ChickenDeliveryBack.persistence.mapper;

import com.Project.ChickenDeliveryBack.domain.dto.SaleDetailDTO;
import com.Project.ChickenDeliveryBack.persistence.entity.SaleDetail;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SaleDetailMapper {

    @Mapping(target = "idVenta", source = "venta.id")
    @Mapping(target = "idProducto", source = "producto.id")
    @Mapping(target = "nombreProducto", source = "producto.nombre")
    SaleDetailDTO toDto(SaleDetail saleDetail);

    @Mapping(target = "venta", ignore = true)
    @Mapping(target = "producto", ignore = true)
    SaleDetail toEntity(SaleDetailDTO saleDetailDTO);
}
package com.Project.ChickenDeliveryBack.persistence.mapper;

import com.Project.ChickenDeliveryBack.domain.dto.PromotionDetailDTO;
import com.Project.ChickenDeliveryBack.persistence.entity.PromotionDetail;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PromotionDetailMapper {

    @Mapping(target = "idVenta", source = "venta.id")
    @Mapping(target = "idPromocion", source = "promocion.id")
    @Mapping(target = "codigoPromocion", source = "promocion.codigo")
    @Mapping(target = "nombrePromocion", source = "promocion.nombre")
    PromotionDetailDTO toDto(PromotionDetail promotionDetail);

    @Mapping(target = "venta", ignore = true)
    @Mapping(target = "promocion", ignore = true)
    PromotionDetail toEntity(PromotionDetailDTO promotionDetailDTO);
}

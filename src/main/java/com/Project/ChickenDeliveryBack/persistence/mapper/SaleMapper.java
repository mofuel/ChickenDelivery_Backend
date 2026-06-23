package com.Project.ChickenDeliveryBack.persistence.mapper;

import com.Project.ChickenDeliveryBack.domain.dto.SaleDTO;
import com.Project.ChickenDeliveryBack.persistence.entity.Sale;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {
        SaleDetailMapper.class,
        PromotionDetailMapper.class,
        DeliveryMapper.class,
        VoucherMapper.class
})
public interface SaleMapper {

    @Mapping(target = "idUsuario", source = "usuario.id")
    @Mapping(target = "nombreUsuario", source = "usuario.nombre")
    @Mapping(target = "idCliente", source = "cliente.id")
    @Mapping(target = "nombreCliente", source = "cliente.nombre")
    @Mapping(target = "detalles", source = "detalles")
    @Mapping(target = "detallePromociones", source = "detallePromociones")
    @Mapping(target = "delivery", source = "delivery")
    @Mapping(target = "comprobante", source = "comprobante")
    SaleDTO toDto(Sale sale);

    @Mapping(target = "usuario", ignore = true)
    @Mapping(target = "cliente", ignore = true)
    @Mapping(target = "detalles", ignore = true)
    @Mapping(target = "detallePromociones", ignore = true)
    @Mapping(target = "delivery", ignore = true)
    @Mapping(target = "comprobante", ignore = true)
    Sale toEntity(SaleDTO saleDTO);
}

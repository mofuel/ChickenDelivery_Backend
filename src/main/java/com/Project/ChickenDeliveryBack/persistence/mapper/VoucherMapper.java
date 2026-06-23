package com.Project.ChickenDeliveryBack.persistence.mapper;

import com.Project.ChickenDeliveryBack.domain.dto.VoucherDTO;
import com.Project.ChickenDeliveryBack.persistence.entity.Voucher;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface VoucherMapper {

    @Mapping(target = "idVenta", source = "venta.id")
    VoucherDTO toDto(Voucher voucher);

    @Mapping(target = "venta", ignore = true)
    Voucher toEntity(VoucherDTO voucherDTO);
}

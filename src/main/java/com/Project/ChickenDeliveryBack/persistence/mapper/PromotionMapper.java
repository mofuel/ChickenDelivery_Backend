package com.Project.ChickenDeliveryBack.persistence.mapper;

import com.Project.ChickenDeliveryBack.domain.dto.PromotionDTO;
import com.Project.ChickenDeliveryBack.persistence.entity.Promotion;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PromotionMapper {

    PromotionDTO toDto(Promotion promotion);

    Promotion toEntity(PromotionDTO promotionDTO);
}

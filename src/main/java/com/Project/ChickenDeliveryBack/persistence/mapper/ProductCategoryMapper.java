package com.Project.ChickenDeliveryBack.persistence.mapper;

import com.Project.ChickenDeliveryBack.domain.dto.ProductCategoryDTO;
import com.Project.ChickenDeliveryBack.persistence.entity.ProductCategory;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductCategoryMapper {

    ProductCategoryDTO toDto(ProductCategory productCategory);

    ProductCategory toEntity(ProductCategoryDTO productCategoryDTO);
}

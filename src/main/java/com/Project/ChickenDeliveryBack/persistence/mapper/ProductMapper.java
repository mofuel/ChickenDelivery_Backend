package com.Project.ChickenDeliveryBack.persistence.mapper;

import com.Project.ChickenDeliveryBack.domain.dto.ProductDTO;
import com.Project.ChickenDeliveryBack.persistence.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {ProductCategoryMapper.class})
public interface ProductMapper {

    @Mapping(target = "idCategoria", source = "categoria.id")
    @Mapping(target = "nombreCategoria", source = "categoria.nombre")
    ProductDTO toDto(Product product);

    @Mapping(target = "categoria", ignore = true)
    Product toEntity(ProductDTO productDTO);
}

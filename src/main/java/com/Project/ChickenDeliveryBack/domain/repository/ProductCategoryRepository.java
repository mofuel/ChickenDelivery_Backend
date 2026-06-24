package com.Project.ChickenDeliveryBack.domain.repository;

import com.Project.ChickenDeliveryBack.domain.dto.ProductCategoryDTO;

import java.util.List;
import java.util.Optional;

public interface ProductCategoryRepository {
    ProductCategoryDTO save(ProductCategoryDTO productCategoryDTO);
    Optional<ProductCategoryDTO> findById(Integer id);
    List<ProductCategoryDTO> findAll();
    Optional<ProductCategoryDTO> findByNombre(String nombre);
    void deleteById(Integer id);
}

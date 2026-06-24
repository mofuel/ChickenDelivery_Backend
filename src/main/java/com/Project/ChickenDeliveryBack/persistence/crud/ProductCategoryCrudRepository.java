package com.Project.ChickenDeliveryBack.persistence.crud;

import com.Project.ChickenDeliveryBack.persistence.entity.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductCategoryCrudRepository extends JpaRepository<ProductCategory, Integer> {
    Optional<ProductCategory> findByNombre(String nombre);
}
package com.Project.ChickenDeliveryBack.persistence.crud;

import com.Project.ChickenDeliveryBack.persistence.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductCrudRepository extends JpaRepository<Product, Integer> {
    List<Product> findByCategoria_Id(Integer idCategoria);
    List<Product> findByNombreContainingIgnoreCase(String nombre);
    List<Product> findByEstado(Boolean estado);
}

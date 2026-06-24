package com.Project.ChickenDeliveryBack.domain.repository;

import com.Project.ChickenDeliveryBack.domain.dto.ProductDTO;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    ProductDTO save(ProductDTO productDTO);
    Optional<ProductDTO> findById(Integer id);
    List<ProductDTO> findAll();
    List<ProductDTO> findByCategoriaId(Integer idCategoria);
    List<ProductDTO> findByNombreContainingIgnoreCase(String nombre);
    List<ProductDTO> findByEstado(Boolean estado);
    void deleteById(Integer id);
}

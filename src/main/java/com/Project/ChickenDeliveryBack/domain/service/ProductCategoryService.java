package com.Project.ChickenDeliveryBack.domain.service;

import com.Project.ChickenDeliveryBack.domain.dto.ProductCategoryDTO;
import com.Project.ChickenDeliveryBack.domain.repository.ProductCategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductCategoryService {

    private final ProductCategoryRepository productCategoryRepository;

    public ProductCategoryService(ProductCategoryRepository productCategoryRepository) {
        this.productCategoryRepository = productCategoryRepository;
    }

    public ProductCategoryDTO save(ProductCategoryDTO dto) {
        if (dto.getNombre() == null || dto.getNombre().isBlank()) {
            throw new IllegalArgumentException("El nombre de la categoría es obligatorio");
        }
        dto.setNombre(dto.getNombre().trim());
        if (productCategoryRepository.findByNombre(dto.getNombre()).isPresent()) {
            throw new IllegalArgumentException("Ya existe una categoría con ese nombre");
        }
        if (dto.getEstado() == null) {
            dto.setEstado(true);
        }
        return productCategoryRepository.save(dto);
    }

    public Optional<ProductCategoryDTO> findById(Integer id) {
        return productCategoryRepository.findById(id);
    }

    public List<ProductCategoryDTO> findAll() {
        return productCategoryRepository.findAll();
    }

    public Optional<ProductCategoryDTO> findByNombre(String nombre) {
        return productCategoryRepository.findByNombre(nombre);
    }

    public void deleteById(Integer id) {
        productCategoryRepository.deleteById(id);
    }
}

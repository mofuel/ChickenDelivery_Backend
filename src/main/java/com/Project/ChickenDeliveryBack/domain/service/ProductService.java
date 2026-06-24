package com.Project.ChickenDeliveryBack.domain.service;

import com.Project.ChickenDeliveryBack.domain.dto.ProductDTO;
import com.Project.ChickenDeliveryBack.domain.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ProductDTO save(ProductDTO dto) {
        if (dto.getNombre() == null || dto.getNombre().isBlank()) {
            throw new IllegalArgumentException("El nombre del producto es obligatorio");
        }
        if (dto.getPrecio() == null || dto.getPrecio().compareTo(java.math.BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("El precio debe ser mayor o igual a 0");
        }
        if (dto.getEstado() == null) {
            dto.setEstado(true);
        }
        dto.setNombre(dto.getNombre().trim());
        return productRepository.save(dto);
    }

    public Optional<ProductDTO> findById(Integer id) {
        return productRepository.findById(id);
    }

    public List<ProductDTO> findAll() {
        return productRepository.findAll();
    }

    public List<ProductDTO> findByCategoriaId(Integer idCategoria) {
        return productRepository.findByCategoriaId(idCategoria);
    }

    public List<ProductDTO> findByNombreContainingIgnoreCase(String nombre) {
        return productRepository.findByNombreContainingIgnoreCase(nombre);
    }

    public List<ProductDTO> findByEstado(Boolean estado) {
        return productRepository.findByEstado(estado);
    }

    public void deleteById(Integer id) {
        productRepository.deleteById(id);
    }
}

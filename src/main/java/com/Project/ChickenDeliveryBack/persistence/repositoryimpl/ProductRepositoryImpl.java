package com.Project.ChickenDeliveryBack.persistence.repositoryimpl;

import com.Project.ChickenDeliveryBack.domain.dto.ProductDTO;
import com.Project.ChickenDeliveryBack.domain.repository.ProductRepository;
import com.Project.ChickenDeliveryBack.persistence.crud.ProductCategoryCrudRepository;
import com.Project.ChickenDeliveryBack.persistence.crud.ProductCrudRepository;
import com.Project.ChickenDeliveryBack.persistence.entity.Product;
import com.Project.ChickenDeliveryBack.persistence.entity.ProductCategory;
import com.Project.ChickenDeliveryBack.persistence.mapper.ProductMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

    private final ProductCrudRepository crudRepository;
    private final ProductMapper mapper;
    private final ProductCategoryCrudRepository productCategoryCrudRepository;

    public ProductRepositoryImpl(ProductCrudRepository crudRepository, ProductMapper mapper, ProductCategoryCrudRepository productCategoryCrudRepository) {
        this.crudRepository = crudRepository;
        this.mapper = mapper;
        this.productCategoryCrudRepository = productCategoryCrudRepository;
    }

    @Override
    public ProductDTO save(ProductDTO productDTO) {
        Product entity = mapper.toEntity(productDTO);
        if (productDTO.getIdCategoria() != null) {
            ProductCategory categoria = productCategoryCrudRepository.findById(productDTO.getIdCategoria())
                    .orElseThrow(() -> new IllegalArgumentException("Categoría no encontrada"));
            entity.setCategoria(categoria);
        }
        return mapper.toDto(crudRepository.save(entity));
    }

    @Override
    public Optional<ProductDTO> findById(Integer id) {
        return crudRepository.findById(id).map(mapper::toDto);
    }

    @Override
    public List<ProductDTO> findAll() {
        return crudRepository.findAll().stream().map(mapper::toDto).collect(Collectors.toList());
    }

    @Override
    public List<ProductDTO> findByCategoriaId(Integer idCategoria) {
        return crudRepository.findByCategoria_Id(idCategoria).stream().map(mapper::toDto).collect(Collectors.toList());
    }

    @Override
    public List<ProductDTO> findByNombreContainingIgnoreCase(String nombre) {
        return crudRepository.findByNombreContainingIgnoreCase(nombre).stream().map(mapper::toDto).collect(Collectors.toList());
    }

    @Override
    public List<ProductDTO> findByEstado(Boolean estado) {
        return crudRepository.findByEstado(estado).stream().map(mapper::toDto).collect(Collectors.toList());
    }

    @Override
    public void deleteById(Integer id) {
        crudRepository.deleteById(id);
    }
}

package com.Project.ChickenDeliveryBack.persistence.repositoryimpl;

import com.Project.ChickenDeliveryBack.domain.dto.ProductDTO;
import com.Project.ChickenDeliveryBack.domain.repository.ProductRepository;
import com.Project.ChickenDeliveryBack.persistence.crud.ProductCrudRepository;
import com.Project.ChickenDeliveryBack.persistence.mapper.ProductMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

    private final ProductCrudRepository crudRepository;
    private final ProductMapper mapper;

    public ProductRepositoryImpl(ProductCrudRepository crudRepository, ProductMapper mapper) {
        this.crudRepository = crudRepository;
        this.mapper = mapper;
    }

    @Override
    public ProductDTO save(ProductDTO productDTO) {
        return mapper.toDto(crudRepository.save(mapper.toEntity(productDTO)));
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
